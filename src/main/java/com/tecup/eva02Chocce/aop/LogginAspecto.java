package com.tecup.eva02Chocce.aop;


import com.tecup.eva02Chocce.domain.entities.*;
import com.tecup.eva02Chocce.domain.persistence.AuditoriaDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Calendar;

@Component
@Aspect
public class LogginAspecto {

    private Long tx;

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Around("execution(* com.tecup.eva02Chocce.service.*ServiceImpl.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result =  null;
        Long currTime = System.currentTimeMillis();
        tx = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = "tx[" + tx + "] - " + joinPoint.getSignature().getName();

        if(joinPoint.getArgs().length > 0)
            logger.info(metodo + "() INPUT:" + Arrays.toString(joinPoint.getArgs()));
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error(e.getMessage());
        }
        logger.info(metodo + "(): tiempo transcurrido " + (System.currentTimeMillis() - currTime) + " ms.");
        return result;
    }

    @After("execution(* com.tecup.eva02Chocce.controllers.*Controller.guardar*(..)) ||" +
            "execution(* com.tecup.eva02Chocce.controllers.*Controller.editar*(..)) ||" +
            "execution(* com.tecup.eva02Chocce.controllers.*Controller.eliminar*(..))")
    public void auditoria(JoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String metodo = joinPoint.getSignature().getName();
        Integer id = null;
        String entityName = "";

        Object[] parametros = joinPoint.getArgs();

        if (metodo.startsWith("guardar")) {
            if (parametros[0] instanceof Career) {
                Career career = (Career) parametros[0];
                id = career.getId();
                entityName = "career";
            } else if (parametros[0] instanceof Depart) {
                Depart depart = (Depart) parametros[0];
                id = depart.getId();
                entityName = "depart";
            } else if (parametros[0] instanceof Event) {
                Event event = (Event) parametros[0];
                id = event.getId();
                entityName = "event";
            } else if (parametros[0] instanceof Score) {
                Score score = (Score) parametros[0];
                id = score.getId();
                entityName = "score";
            } else if (parametros[0] instanceof Tourment) {
                Tourment tourment = (Tourment) parametros[0];
                id = tourment.getId();
                entityName = "tourment";
            } else if (parametros[0] instanceof Usuario) {
                Usuario usuario = (Usuario) parametros[0];
                id = usuario.getId();
                entityName = "usuario";
            } else {
                logger.error("Parámetro inesperado en guardar: " + parametros[0].getClass());
                return;
            }
        } else if (metodo.startsWith("editar") || metodo.startsWith("eliminar")) {
            id = (Integer) parametros[0];
            // Asume que id es el primer parámetro; puedes adaptarlo si no es el caso.
            entityName = obtenerEntityNameDesdeMetodo(metodo); // Función auxiliar
        }

        String traza = "tx[" + tx + "] - " + metodo;
        logger.info(traza + "(): registrando auditoría...");
        auditoriaDao.save(new Auditoria(entityName, id, Calendar.getInstance().getTime(), "usuario", metodo));
    }

    private String obtenerEntityNameDesdeMetodo(String metodo) {
        if (metodo.contains("Career")) return "career";
        if (metodo.contains("Depart")) return "depart";
        if (metodo.contains("Event")) return "event";
        if (metodo.contains("Score")) return "score";
        if (metodo.contains("Tourment")) return "tourment";
        if (metodo.contains("Usuario")) return "usuario";
        return "desconocido";
    }
}


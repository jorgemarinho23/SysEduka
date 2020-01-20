/**
 * @author Jorge marinho on 26 de dez de 2019
 *
 * 
 */
package com.jm.educacao.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE })
public @interface MatriculaEdicao {

}

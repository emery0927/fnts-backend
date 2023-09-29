/**
 * 
 */
package com.fnts.fnts.back.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Emery Estupiñan
 *
 */
@Getter @Setter @NoArgsConstructor @ToString
public class ActivityContent {
	
	private Integer idActInJson;
	private String nombreActividad;
	private Integer numeroDiapositivas;
	private ArrayList<Slides> diapositivas;
	private boolean existeQuiz;
	private Integer numeroPreguntas;
	private ArrayList<Quiz> quiz;
	
	

}

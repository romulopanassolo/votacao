package br.com.softdesign.votacao.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class CalcularPercentualUtil implements CalcularPercentualInterface {
	
	private static final int DOIS = 2;
	private static final int CEM = 100;
	
	@Override
	public Double  percentual(Long valor, Long total) {
		Double percentual = (double) (valor * CEM) / total;
		
		return new BigDecimal(percentual).setScale(DOIS, RoundingMode.HALF_UP).doubleValue();
	}

	
	

}

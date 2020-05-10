package br.com.softdesign.votacao.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularPercentualUtil {
	
	private static final int DOIS = 2;
	private static final int CEM = 100;

	public static Double  percentual(Long valor, Long total) {
		Double percentual = (double) (valor * CEM) / total;
		
		return new BigDecimal(percentual).setScale(DOIS, RoundingMode.HALF_UP).doubleValue();
	}

}

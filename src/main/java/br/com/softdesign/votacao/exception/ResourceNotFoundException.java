package br.com.softdesign.votacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softdesign.votacao.message.MessageKey;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BaseRuntimeException {

	private static final long serialVersionUID = 7812924531615187715L;
	
	public ResourceNotFoundException(MessageKey messageKey, Object ...args) {
		super(messageKey, args);
	}

}

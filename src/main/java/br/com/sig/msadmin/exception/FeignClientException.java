package br.com.sig.msadmin.exception;

public class FeignClientException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public FeignClientException(String msg) {
		super(msg);
	}
	
	public FeignClientException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

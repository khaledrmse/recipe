package com.example.recipe.exceptionhandler;

import java.time.Instant;
/**
 * 
 * class to customize our error detail
 *
 */
public class ErrorDetail {
	private String errormessage;
    private String url;
    private Instant errortime;

    public ErrorDetail() {
        this.errortime = Instant.now();
    }
    
	public ErrorDetail(String errormessage, String url) {
		super();
		this.errortime = Instant.now();
		this.errormessage = errormessage;
		this.url = url;
	}




	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Instant getErrortime() {
		return errortime;
	}

	public void setErrortime(Instant errortime) {
		this.errortime = errortime;
	}
    
}

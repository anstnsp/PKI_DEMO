package com.aton.message.common.exception;

import com.aton.message.common.code.UCPIDErrorCode;

public class UCPIDMessageException extends UCPIDException {

    private static final long serialVersionUID = 3189069805347171458L;

    public UCPIDMessageException(UCPIDErrorCode errorCode) {
      super(errorCode);
    }
  
    public UCPIDMessageException(UCPIDErrorCode errorCode, Throwable cause) {
      super(errorCode, cause);
    }
  
    public UCPIDMessageException(Throwable cause) {
      super(cause);
    }
    
}
  
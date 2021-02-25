package com.aton.message.common.exception;

import com.aton.message.common.code.UCPIDCommonErrorCode;
import com.aton.message.common.code.UCPIDErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UCPIDException extends RuntimeException {

    private static final long serialVersionUID = 5857919165874102230L;
    UCPIDErrorCode errorCode;
  
    public UCPIDException(UCPIDErrorCode errorCode) {
      super("[" + errorCode.getCode() + "] " + errorCode.getMsg());
      this.setErrorCode(errorCode);
    }
  
    public UCPIDException(UCPIDErrorCode errorCode, String errorMessage) {
      super("[" + errorCode.getCode() + "] " + errorCode.getMsg() + " - " + errorMessage);
      this.setErrorCode(errorCode);
    }
  
    public UCPIDException(UCPIDErrorCode errorCode, Throwable cause) {
      super("[" + errorCode.getCode() + "] " + errorCode.getMsg() + " - " + UCPIDException.makeStackTraceString(cause));
      this.setErrorCode(errorCode);
    }
  
    public UCPIDException(UCPIDErrorCode errorCode, Exception e) {
      super("[" + errorCode.getCode() + "] " + errorCode.getMsg() + " - " + UCPIDException.makeStackTraceString(e));
      this.setErrorCode(errorCode);
    }
  
    public UCPIDException(Throwable cause) {
      super("[" + UCPIDCommonErrorCode.UNKNOWN.getCode() + "] " + UCPIDCommonErrorCode.UNKNOWN.getMsg() + " - " + UCPIDException.makeStackTraceString(cause));
      this.setErrorCode(UCPIDCommonErrorCode.UNKNOWN);
    }
  
    private static String makeStackTraceString(Object obj) {
      if (null == obj) {
        return "cause is null";
      }
  
      StackTraceElement[] elements = null;
  
      if(obj instanceof Exception) {
        elements = ((Exception)obj).getStackTrace();
        if(elements == null || elements.length < 1) return ((Exception)obj).getMessage();
      } else if(obj instanceof Throwable) {
        elements = ((Throwable)obj).getStackTrace();
        if(elements == null || elements.length < 1) return ((Throwable)obj).getMessage();
      }
  
      if (null == elements) {
        return "stacktrace is empty";
      }
  
      StringBuilder buffer = new StringBuilder();
      buffer
          .append("\n")
          .append("[====================Stack Trace START====================]\n");
  
      int count = 1;
      for (StackTraceElement element : elements) {
        if (null == element || count > 15) {
          break;
        }
  
        buffer.append(element.toString()).append("\n");
        count++;
      }
      buffer.append("[====================Stack Trace E N D====================]");
      return buffer.toString();
    }
  }
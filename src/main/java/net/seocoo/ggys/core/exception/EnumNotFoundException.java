package net.seocoo.ggys.core.exception;

/**
 * 枚举不存在异常
 * @author ZengXiaoLiang
 * @date 2018/5/28 10:10
 **/
public class EnumNotFoundException extends Exception{

  private static final long serialVersionUID = 1074840691750906581L;

  public EnumNotFoundException(String message) {
    super(message);
  }

  public EnumNotFoundException(String message, Throwable exception) {
    super(message, exception);
  }
}

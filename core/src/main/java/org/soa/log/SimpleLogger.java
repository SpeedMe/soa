package org.soa.log;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleLogger implements Logger {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

  private static PrintStream outprint = System.out;

  private int level = Level.DEBUG;

  protected String name;

  public SimpleLogger() {
    String currentClassName = Thread.currentThread().getStackTrace()[2].getClassName();
    this.name = currentClassName;
  }

  public SimpleLogger(Class<?> type) {
    this.name = type.getName();
  }

  private String getLevel(int level) {
    if (level <= Level.TRACE) {
      return "TRACE";
    }
    if (level <= Level.DEBUG) {
      return "DEBUG";
    }
    if (level <= Level.INFO) {
      return "INFO";
    }
    if (level <= Level.WARN) {
      return "WARN";
    }
    if (level <= Level.ERROR) {
      outprint = System.err;
      return "ERROR";
    }
    if (level <= Level.FATAL) {
      return "FATAL";
    }
    return "DEBUG";
  }

  private String now() {
    return sdf.format(new Date());
  }

  /**
   * trace.
   */
  public void trace(String message) {
    if (level <= Level.TRACE) {
      log(Level.TRACE, message);
    }
  }

  /**
   * trace.
   */
  public void trace(String message, Object... args) {
    if (level <= Level.TRACE) {
      log(Level.TRACE, message, args);
    }
  }

  /**
   * trace.
   */
  public void trace(String message, Throwable tw) {
    if (level <= Level.TRACE) {
      log(Level.TRACE, message, tw);
    }
  }

  /**
   * trace.
   */
  public void trace(String message, Throwable tw, Object... args) {
    if (level <= Level.TRACE) {
      log(Level.TRACE, message, tw, args);
    }
  }

  /**
   * debug.
   */
  public void debug(String message) {
    if (level <= Level.DEBUG) {
      log(Level.DEBUG, message);
    }
  }

  /**
   * debug.
   */
  public void debug(String message, Object... args) {
    if (level <= Level.DEBUG) {
      log(Level.DEBUG, message, args);
    }
  }

  /**
   * debug.
   */
  public void debug(String message, Throwable tw) {
    if (level <= Level.DEBUG) {
      log(Level.DEBUG, message, tw);
    }
  }

  /**
   * debug.
   */
  public void debug(String message, Throwable tw, Object... args) {
    if (level <= Level.DEBUG) {
      log(Level.DEBUG, message, tw, args);
    }
  }

  /**
   * info.
   */
  public void info(String message) {
    if (level <= Level.INFO) {
      log(Level.INFO, message);
    }
  }

  /**
   * info.
   */
  public void info(String message, Object... args) {
    if (level <= Level.INFO) {
      log(Level.INFO, message, args);
    }
  }

  /**
   * info.
   */
  public void info(String message, Throwable tw) {
    if (level <= Level.INFO) {
      log(Level.INFO, message, tw);
    }
  }

  /**
   * info.
   */
  public void info(String message, Throwable tw, Object... args) {
    if (level <= Level.INFO) {
      log(Level.INFO, message, tw, args);
    }
  }

  /**
   * warn.
   */
  public void warn(String message) {
    if (level <= Level.WARN) {
      log(Level.WARN, message);
    }
  }

  /**
   * warn.
   */
  public void warn(String message, Object... args) {
    if (level <= Level.WARN) {
      log(Level.WARN, message, args);
    }
  }

  /**
   * warn.
   */
  public void warn(String message, Throwable tw) {
    if (level <= Level.WARN) {
      log(Level.WARN, message, tw);
    }
  }

  /**
   * warn.
   */
  public void warn(String message, Throwable tw, Object... args) {
    if (level <= Level.WARN) {
      log(Level.WARN, message, tw, args);
    }
  }

  /**
   * error.
   */
  public void error(String message) {
    if (level <= Level.ERROR) {
      log(Level.ERROR, message);
    }
  }

  /**
   * error.
   */
  public void error(String message, Object... args) {
    if (level <= Level.ERROR) {
      log(Level.ERROR, message, args);
    }
  }

  /**
   * error.
   */
  public void error(String message, Throwable tw) {
    if (level <= Level.ERROR) {
      log(Level.ERROR, message, tw);
    }
  }

  /**
   * error.
   */
  public void error(String message, Throwable tw, Object... args) {
    if (level <= Level.ERROR) {
      log(Level.ERROR, message, tw, args);
    }
  }

  public boolean isDebugEnabled() {
    return level <= Level.DEBUG;
  }

  public boolean isErrorEnabled() {
    return level <= Level.ERROR;
  }

  public boolean isInfoEnabled() {
    return level <= Level.INFO;
  }

  public boolean isWarnEnabled() {
    return level <= Level.WARN;
  }

  /**
   * log.
   */
  public void log(int level, String message, Object... args) {
    log(level, message, null, args);
  }

  /**
   * log.
   */
  public void log(int level, String message, Throwable tw, Object... args) {

    StringBuilder sb = new StringBuilder(now());
    sb.append(" ").append(getLevel(level)).append(" ");
    sb.append("[").append(Thread.currentThread().getName()).append("]").append(" ");
    sb.append(this.name).append(" | ");
    sb.append(format(message, args));

    outprint.println(sb.toString());
    if (tw != null) {
      tw.printStackTrace(System.err);
      System.err.flush();
    }
  }

  protected String format(String message, Object... args) {
    if (message == null) {
      return null;
    }
    if (args == null || args.length == 0) {
      if (message.indexOf("{}") != -1) {
        message = message.replaceAll("\\{\\}", "");
      }
      return message.toString();
    } else {
      if (message.indexOf("{}") != -1) {
        message = message.replaceAll("\\{\\}", "%s");
      }
      return String.format(message.toString(), args);
    }
  }

}
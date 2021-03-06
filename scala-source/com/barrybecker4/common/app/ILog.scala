/* Copyright by Barry G. Becker, 2000-2018. Licensed under MIT License: http://www.opensource.org/licenses/MIT */
package com.barrybecker4.common.app

import java.io.FileNotFoundException


/**
  * Provide support for general logging.
  * @author Barry Becker
  */
trait ILog {

  /** Set the log destination
    * Should eventually allow multiples using | to combine the hex constants.
    */
  def setDestination(logDestination: Int): Unit

  /** @return the current logging destination*/
  def getDestination: Int

  /** @param fileName the name of the file to send the output to.*/
  @throws[FileNotFoundException]
  def setLogFile(fileName: String): Unit

  /** for logging to a string. */
  def setStringBuilder(bldr: StringBuilder): Unit

  /**
    * Log a message to the logDestination
    * @param logLevel    message will only be logged if this number is less than the application logLevel (debug_)
    * @param appLogLevel the applications log level.
    * @param message     the message to log
    */
  def print(logLevel: Int, appLogLevel: Int, message: String): Unit

  /** Log a message to the logDestination followed by a newline.
    * @param logLevel    message will only be logged if this number is less than the application logLevel (debug_)
    * @param appLogLevel the applications log level.
    * @param message     the message to log
    */
  def println(logLevel: Int, appLogLevel: Int, message: String): Unit
  def print(message: String): Unit
  def println(message: String): Unit
}
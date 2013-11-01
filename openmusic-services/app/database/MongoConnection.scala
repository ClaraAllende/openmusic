package database

import com.mongodb.MongoClient
import de.flapdoodle.embed.mongo._
import de.flapdoodle.embed.mongo.config.{RuntimeConfigBuilder, MongodConfig}
import de.flapdoodle.embed.process.config.io.ProcessOutput
import de.flapdoodle.embed.process.io.{Processors, IStreamProcessor}
import java.io._
import de.flapdoodle.embed.mongo.distribution.Version
import model.configuration.Configuration

trait MongoConnection {

  object MongoHelper {
  lazy val mongoServer = Configuration.mongodbServer.split(":")
  lazy val host = mongoServer(0)
  lazy val port = mongoServer(1).toInt

  val version = Version.V2_2_3
  val mongodOutput = Processors.named("[mongod>]", new FileStreamProcessor(createLogFile("mongod.log")))
  val mongodError = new FileStreamProcessor(createLogFile("mongod-error.log"))
  val commandsOutput = Processors.namedConsole("[console>]")

  lazy val runtimeConfig = new RuntimeConfigBuilder()
    .defaults(Command.MongoD)
    .processOutput(new ProcessOutput(mongodOutput, mongodError, commandsOutput))
    .build()
  lazy val runtime: MongodStarter = MongodStarter.getInstance(runtimeConfig)
  lazy val mongoExecutable: MongodExecutable = runtime.prepare(new MongodConfig(version, port, true))
  lazy val mongoProcess: MongodProcess = mongoExecutable.start()
  lazy val mongoInstance = new MongoClient(host, port)

  private def createLogFile(filename: String) = {
    val logFile = new File("logs/" + filename)
    logFile.getParentFile.mkdirs()
    logFile
  }
}
}

  
class FileStreamProcessor(val outputStream: FileOutputStream) extends IStreamProcessor {
  def this(file: File) = this(new FileOutputStream(file))

  override def process(block: String) {
    try {
      outputStream.write(block.getBytes)
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  override def onProcessed() {
    try {
      outputStream.close()
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }
}
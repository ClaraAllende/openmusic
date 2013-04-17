OpenMusic
=========

Como correr OpenMusic?
=======================================

Necesitan tener instalado Play 2.1.1 (lo pueden bajar de http://www.playframework.com/download).Lo descomprimen donde quieran.
Si tienen sbt, probablemente les baje play al bajar las dependencias, así que no haría falta descargar el zip.
Hay que ir desde la consola hasta el directorio donde está la aplicación, y desde ahí abrir una consola de Play.

callende@paradisecity:~/openmusic/openmusic-services$ sbt
[info] Loading project definition from /home/callende/.local/share/Trash/files/openmusic/openmusic-services/project
[info] Set current project to openmusic-services (in build file:/home/callende/.local/share/Trash/files/openmusic/openmusic-services/)

[openmusic-services] $ play
       _            _
 _ __ | | __ _ _  _| |
| '_ \| |/ _' | || |_|
|  __/|_|\____|\__ (_)
|_|            |__/

play! 2.1.1 (using Java 1.7.0_15 and Scala 2.10.0), http://www.playframework.org

> Type "help play" or "license" for more information.
> Type "exit" or use Ctrl+D to leave this console.

[openmusic-services] $ run
Si no le ponen nada, play levanta la aplicación en el puerto default, que es el 9000. Si quieren levantarla en otro puerto, solo pongan el número después de run:

[openmusic-services] $ run 8085

--- (Running the application from SBT, auto-reloading is enabled) ---

[info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:8085

(Server started, use Ctrl+D to stop and go back to the console...)

Después no tienen más que ir a su browser amigo e ingresar la url https://localhost:8085/song :)

Más info en http://www.playframework.com/documentation/2.1.1/PlayConsole

Como generar el JAR de OpenMusic Node?
======================================

[openmusic-services] $ dist

Genera un zip con todos los JARs necesarios para correr la aplicación como standalone.

Más info en http://www.playframework.com/documentation/2.1.1/ProductionDist



SideEffect!deas 2013

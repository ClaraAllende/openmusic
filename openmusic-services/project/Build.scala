/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - project
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*
*   Project: http://github.com/SideEffectIdeas/openmusic-node
*   Wiki: http://github.com/SideEffectIdeas/openmusic-node/wiki
*   Mailing list: http://groups.google.com/group/sideEffectIdeas
*/
import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "openmusic-services"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "com.google.code.gson" % "gson" % "2.2.2",
     "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.31" exclude("commons-io", "commons-io"),
     "org.mongodb" %% "casbah" % "2.6.3"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}

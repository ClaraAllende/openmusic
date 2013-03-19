/*Copyright (c) 2013 -  SideEffectIdeas 
*
*	Module: test - openmusic - node
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


package ar.com.sideeffect.openmusic.node.test

import org.specs2.mutable.Specification
import org.specs2.matcher.ShouldMatchers
import org.specs2.mutable._
import ar.com.blout.openmusic.node.metadata.Metadata
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import ar.com.blout.openmusic.node.configuration.Configuration
import ar.com.blout.openmusic.node.playlist.Playlist

@RunWith(classOf[JUnitRunner])
class PlaylistTest extends Specification {

  var port: Int = _

  case class UserContext extends Before {
    def before = {
      var config = getClass.getClassLoader.getResource("configuration.properties")
      Configuration config config.getPath
      port = Configuration getInt "port"
    }

  }

  "Song metadata" should {
    "be transformed into M3U line" in new UserContext {

      var metadata = new Metadata
      metadata.autor = "Mago de Oz"
      metadata.path = "/algun/path/loco/desde-mi-cielo.mp3"
      metadata.nombre = "Desde mi cielo"
      metadata.uuid = metadata.path.hashCode()

      var result = metadata.toM3u

      //Primero se ira por el camino de no especificar 
      //la duracion de la pista, por eso el "-1"
      var expected = "#EXTINF:-1,Mago de Oz - Desde mi cielo\n" +
        "http://localhost:" + port + "/openmusic/music/song/" + metadata.uuid

      result must be equalTo (expected)
    }
  }

  "Playlist" should {
    "return a m3u playlist" in new UserContext {

      //refactorizar aca para sacar el repetido
      //con respecto al test anterior
      var metadata = new Metadata
      metadata.autor = "Mago de Oz"
      metadata.path = "/algun/path/loco/desde-mi-cielo.mp3"
      metadata.nombre = "Desde mi cielo"
      metadata.uuid = metadata.path.hashCode()

      var metadata2 = new Metadata
      metadata2.autor = "Mago de Oz"
      metadata2.path = "/algun/path/loco/desde-mi-cielo2.mp3"
      metadata2.nombre = "Desde mi cielo2"
      metadata2.uuid = metadata2.path.hashCode()

      var playlist = new Playlist
      playlist add metadata
      playlist add metadata2

      var result = playlist.toM3U

      var expected = "#EXTM3U\n#EXTINF:-1,Mago de Oz - Desde mi cielo\n" +
        "http://localhost:" + port + "/openmusic/music/song/" + metadata.uuid +
        "\n#EXTINF:-1,Mago de Oz - Desde mi cielo2\n" +
        "http://localhost:" + port + "/openmusic/music/song/" + metadata2.uuid

      result must be equalTo (expected)

    }
  }

}
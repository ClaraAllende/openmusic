/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - metadata
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

package model.metadata

import java.io.File
import model.playlist._

class Metadata extends M3UElement {

  var nombre: String = _
  var autor: String = _
  var nodo: String = _
  var path: String = _
  var uuid: Int = _

  /**
   * Se encarga de obtener ese archivo de media y devolverlo para poder ser consumido
   */
  def retrieve: File = new File(path)
  def addTo(playlist: Playlist) = playlist add this

  // M3U implementation
  def duration = "-1"
  def title = autor + " - " + nombre
  def url = "http://localhost:" + 9000 + "/song/" + uuid

}
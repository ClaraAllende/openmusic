/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - playlist
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

package model.playlist

import model.metadata.Metadata


class Playlist extends M3UPlaylist {

  var id: String = _
  var name: String = _
  var elements: List[Metadata] = List()

  def add(element: Metadata) = elements = elements :+ element

  def m3uElements = elements.map({ elem => elem.toM3u })

}
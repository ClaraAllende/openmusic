/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic - metadata
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

/**
 *
 */
object MetadataManager {


  def all: List[Metadata] = {

    return new File("/Users/adrielrubenparedes/Music/chelu")
      .listFiles()
      .filter({ elem => elem.isFile() })
      .map({ elem => this createMetadata elem })
      .toList

  }

  def find(id: Int): Metadata = {
    return this.all.find { elem => elem.uuid.equals(id) }.get
  }

  def createMetadata(file: File): Metadata = {
    var metadata = new Metadata
    metadata.uuid = file.getPath.hashCode
    metadata.nombre = file.getName()
    metadata.path = file.getAbsolutePath()
    return metadata
  }

}
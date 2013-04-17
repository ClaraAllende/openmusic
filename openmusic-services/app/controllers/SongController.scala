/*Copyright (c) 2013 -  SideEffectIdeas
*
*	Module: openmusic-services - controllers
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
package controllers

import play.api._
import play.api.mvc._
import model.metadata.MetadataManager
import model.services.Jsonable
import views.html

object SongController extends Controller with Jsonable {
	
  def index = Action {
    Ok(html.index(MetadataManager.recursiveAll))
  }

  def list = Action {
    Ok {
      ListToJson(MetadataManager.recursiveAll)
    }
  }

  def metadata(id : Int) = Action {
    Ok{
      toJson(MetadataManager.find(id))
    }
  }

  def retrieve(id: Int) = Action {
    Ok.sendFile {
      MetadataManager.find(id).retrieve
    }
  }

}

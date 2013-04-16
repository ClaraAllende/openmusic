package views
import model.metadata.MetadataManager
import model.metadata.Metadata

object Helper {

	def getSongs = MetadataManager.recursiveAll
		
	def getInfo(song: Metadata) = (song.nombre, song.path, song.uuid)

	def getName(song:Metadata) = song.nombre

	def getPath(song: Metadata) = song.path
	
	def getUUID(song: Metadata) = song.uuid
}


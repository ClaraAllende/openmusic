requirejs.config({
	
	paths: {
		libs:'libs',
		templates:'../templates',
		jquery:'libs/jquery-1.9.0.min'
	       },
	shim: {
		"libs/handlebars":{
			exports: 'Handlebars'
		},
		"libs/underscore":{
			exports: '_'
		},
		"libs/backbone":{
			exports:'Backbone',
			deps:['libs/underscore']
		},
		"libs/jquery.jplayer":{
			exports:"jplayer"
		}

	      }

});



require([
	"views/HomeView",
	"views/SongsView",
	"views/PlayerView"
	],

	function(HomeView,SongsView,PlayerView){

	new HomeView();
	new SongsView();



});
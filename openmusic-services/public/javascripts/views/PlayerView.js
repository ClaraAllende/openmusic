define([
	"libs/underscore",
	"libs/backbone",
	"libs/handlebars",
	'jquery',
	"libs/text!templates/player.html"],




	function(_,Backbone,Handlebars,$,playerTemplate){


	PlayerView = Backbone.View.extend({

		el:$('#content'),

		template: Handlebars.compile(playerTemplate),


		initialize:function(){
			this.render();
		},


		render:function(){
			this.$el.append(this.template());
		}


	});



	return PlayerView;

});
define([
	"libs/underscore",
	"libs/backbone",
	"libs/handlebars",
	'jquery',
	"libs/text!templates/home.html"],




	function(_,Backbone,Handlebars,$,homeTemplate){

	HomeView = Backbone.View.extend({

		el: $('#content'),

		template: Handlebars.compile(homeTemplate),

		initialize:function(){
			this.render();
		},

		render:function(){
			this.$el.append(this.template());
		}

	});


	return HomeView;


});
define([
	"libs/underscore",
	"libs/backbone",
	"libs/handlebars",
	'jquery',
	"models/Song"],




	function(_,Backbone,Handlebars,$,Song){

	Songs = Backbone.Collection.extend({

		model:Song ,

		url: 'song/list'

	});


	return Songs;


});
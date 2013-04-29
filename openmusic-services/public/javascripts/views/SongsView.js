define([
	"libs/underscore",
	"libs/backbone",
	"libs/handlebars",
	'jquery',
	'collections/Songs',
	"libs/text!templates/songs-table.html"],




	function(_,Backbone,Handlebars,$,Songs,songsTemplate){


		var songs = new Songs();


		SongsView = Backbone.View.extend({

			el: $('#content'),

			template: Handlebars.compile(songsTemplate),

			events: 
			{
				"click tr" : "play"
			},

			play:function(e){
				var id = $(e.currentTarget).data("id");
				window.open(
					'/song/'+id,
					'_blank'
					);
				console.log(id);
			},

			initialize:function(){
				this.render();
			},

			render:function(){

				var me = this;

				songs.fetch({

					success:function(){

						var col = _.map(songs.models,function(elem){ return elem.toJSON(); });
						console.log(col);
						me.$el.append(me.template({songs: col} ));

					}


				});


			}

		});


		return SongsView;


	});
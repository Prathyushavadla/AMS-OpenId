/*******************************************************************************
 * Copyright 2017 The MIT Internet Trust Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
var BlackListModel = Backbone.Model.extend({
	idAttribute: 'id',

	urlRoot: 'api/blacklist'
});

var BlackListCollection = Backbone.Collection.extend({
	initialize: function() {
	},

	url: "api/blacklist"
});

var BlackListListView = Backbone.View.extend({
	tagName: 'span',

	initialize: function(options) {
		this.options = options;
	},

	load: function(callback) {
		if (this.collection.isFetched) {
			callback();
			return;
		}

		$('#loadingbox').sheet('show');
		$('#loading').html('<span class="label" id="loading-blacklist">' + $.t('admin.blacklist') + '</span> ');

		$.when(this.collection.fetchIfNeeded({
			success: function(e) {
				$('#loading-blacklist').addClass('label-success');
			},
			error: app.errorHandlerView.handleError()
		})).done(function() {
			$('#loadingbox').sheet('hide');
			callback();
		});
	},

	events: {
		"click .refresh-table": "refreshTable",
		"click .btn-add": "addItem",
		"submit #add-blacklist form": "addItem"
	},

	refreshTable: function(e) {
		e.preventDefault();

		var _self = this;
		$('#loadingbox').sheet('show');
		$('#loading').html('<span class="label" id="loading-blacklist">' + $.t('admin.blacklist') + '</span> ');

		$.when(this.collection.fetch()).done(function() {
			$('#loadingbox').sheet('hide');
			_self.render();
		});
	},

	togglePlaceholder: function() {
		if (this.collection.length > 0) {
			$('#blacklist-table', this.el).show();
			$('#blacklist-table-empty', this.el).hide();
		} else {
			$('#blacklist-table', this.el).hide();
			$('#blacklist-table-empty', this.el).show();
		}
	},

	render: function(eventName) {

		$(this.el).html($('#tmpl-blacklist-table').html());

		var _self = this;
		_.each(this.collection.models, function(blacklist) {
			var view = new BlackListWidgetView({
				model: blacklist
			});
			view.parentView = _self;
			$("#blacklist-table", _self.el).append(view.render().el);
		}, this);

		this.togglePlaceholder();

		$(this.el).i18n();
		return this;
	},

	addItem: function(e) {
		e.preventDefault();

		var input_value = $("#blacklist-uri", this.el).val().trim();

		if (input_value === "") {
			return;
		}

		// TODO: URI/pattern validation, check against existing clients

		var item = new BlackListModel({
			uri: input_value
		});

		var _self = this; // closures...

		item.save({}, {
			success: function() {
				_self.collection.add(item);
				_self.render();
			},
			error: app.errorHandlerView.handleError()
		});

	}

});

ui.routes.push({
	path: "user/changepassword",
	name: "changepassword",
	callback: function() {

		if (!isAdmin()) {
			this.root();
			return;
		}

		this.breadCrumbView.collection.reset();
		this.breadCrumbView.collection.add([{
			text: $.t('admin.home'),
			href: ""
		}, {
			text: $.t('admin.changepassword'),
			href: "manage/#user/changepassword"
		}]);

		this.updateSidebar('admin/blacklist');

		var view = new BlackListListView({
			collection: this.blackListList
		});

		view.load(function(collection, response, options) {
			$('#content').html(view.render().el);
			setPageTitle($.t('admin.changepassword'));
		});
	}

});

ui.templates.push('resources/template/changepassword.html');

ui.init.push(function(app) {
	app.blackListList = new BlackListCollection();
});

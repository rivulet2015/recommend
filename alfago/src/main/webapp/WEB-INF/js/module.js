function Module(pageId) {
	this.pageId = pageId;
	this.selectAllUrl = "/module/list.do";
	this.addUrl = "/module/add.do";
	this.updateUrl = "/module/update.do";
	this.delUrl = "/module/delete.do";
}

Module.prototype.selectAll = function($selector) {

	return $.ajax({
		type : "GET",
		url : this.selectAllUrl,
		data : {
			'pageId' : this.pageId
		},
		dataType : "json"
	});
}
Module.prototype.add = function($selector) {
	var name = $selector.find(".name input").val();
	var data = {
		'name' : name,
		'pageId' : this.pageId
	};

	return $.ajax({
		type : "POST",
		url : this.addUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});
}
Module.prototype.edit = function($selector) {

	$selector.find(".editable").each(function() {
		var text = $(this).text();
		$(this).html("<input type='text'  class='form-control'>");
		$(this).find("input").val(text);

	});

}
Module.prototype.update = function($selector) {

	var name = $selector.find(".name input").val();
	var id = $selector.find(".id").text();
	var data = {
		'id' : id,
		'name' : name,
		'pageId' : this.pageId
	};

	return $.ajax({
		type : "POST",
		url : this.updateUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});

}

Module.prototype.del = function($selector, callback) {

	var id = $selector.find(".id").text();
	var data = {
		'id' : id,
		'pageId' : this.pageId
	};
	return $.ajax({
		type : "GET",
		url : this.delUrl,
		data : data,
		dataType : "json"
	});
}

function Table($selector) {
	this.$selector = $($selector);
	this.source = $("#template").html();
	this.template = Handlebars.compile(this.source);
	this.table_source = $("#table-template").html();
	this.table_template = Handlebars.compile(this.table_source);
}
Table.prototype.add = function() {

	var html = this.template();
	this.$selector.find("tbody").append(html);

}
Table.prototype.edit = function($selector) {

	$selector.find(".editable").each(function() {
		var text = $(this).text();
		$(this).html("<input type='text'  class='form-control'>");
		$(this).find("input").val(text);

	});

}
Table.prototype.confirm = function($selector, response) {

	$selector.find(".editable").each(function() {
		$(this).html("");

	});
	$selector.find(".id").html(response.id);
	$selector.find(".name").html(response.name);
}

Table.prototype.del = function($selector) {

	$selector.remove();

}

Table.prototype.init = function() {

	var getQueryString = function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	};
	var pageId = getQueryString('pageId');
	var module = new Module(pageId);
	this.module = module;
	var table = this;

	module.selectAll().then(function(response) {
		var tbody = table.table_template(response);
		table.$selector.find("tbody").html(tbody);
	});

	$('#add_btn').on('click', function() {
		table.add();
	});

	$('table').on('click', '.edit', function() {
		$(this).removeClass("edit  btn-primary");
		$(this).addClass("confirm  btn-success");
		$(this).html("<i class='glyphicon glyphicon-ok-sign'></i>Confirm");
		var $selector = $(this).parents("tr");
		table.edit($selector);
	});

	$('table').on('click', '.confirm', function() {

		$(this).removeClass("confirm  btn-success");
		$(this).addClass("edit  btn-primary ");
		$(this).html("<i class='glyphicon glyphicon-pencil'></i>Edit");
		var $selector = $(this).parents("tr");
		var id = $selector.find(".id").html();
		if (id == undefined || id == "") {
			module.add($selector).then(function(response) {
				table.confirm($selector, response);

			})
		} else {
			module.update($selector).then(function(response) {
				table.confirm($selector, response);

			})
		}

	});

	$('table').on('click', '.delete', function() {

		var $selector = $(this).parents("tr");

		var id = $selector.find(".id").html();
		if (id == undefined || id == "") {
			table.del($selector);
		} else {
			module.del($selector).then(function(response) {
				table.del($selector);

			});
		}
	});

}

/* Table initialisation */
$(document).ready(function() {
	var table = new Table($("#example"));
	table.init();

});
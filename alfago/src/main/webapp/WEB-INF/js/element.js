function Element(pageId, moduleId) {
	this.pageId = pageId;
	this.moduleId = moduleId;
	this.selectAllUrl = "/element/list.do";
	this.addUrl = "/element/add.do";
	this.updateUrl = "/element/update.do";
	this.delUrl = "/element/delete.do";
}

Element.prototype.selectAll = function($selector) {

	return $.ajax({
		type : "GET",
		url : this.selectAllUrl,
		data : {
			'pageId' : this.pageId,
			'moduleId' : this.moduleId
		},
		dataType : "json"
	});
}
Element.prototype.add = function($selector) {
	var keyname = $selector.find(".keyname input").val();
	var value = $selector.find(".value input").val();
	var data = {
		'keyname' : keyname,
		'value' : value,
		'pageId' : this.pageId,
		'moduleId' : this.moduleId
	};

	return $.ajax({
		type : "POST",
		url : this.addUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});
}
Element.prototype.edit = function($selector) {

	$selector.find(".editable").each(function() {
		var text = $(this).text();
		$(this).html("<input type='text'  class='form-control'>");
		$(this).find("input").val(text);

	});

}
Element.prototype.update = function($selector) {

	var id = $selector.find(".id").text();
	var keyname = $selector.find(".keyname input").val();
	var value = $selector.find(".value input").val();
	var data = {
		'id' : id,
		'keyname' : keyname,
		'value' : value,
		'pageId' : this.pageId,
		'moduleId' : this.moduleId
	};

	return $.ajax({
		type : "POST",
		url : this.updateUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});

}

Element.prototype.del = function($selector, callback) {

	var id = $selector.find(".id").text();
	var data = {
		'id' : id,
		'pageId' : this.pageId,
		'moduleId' : this.moduleId
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
	$selector.find(".keyname").html(response.keyname);
	$selector.find(".value").html(response.value);
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
	var moduleId = getQueryString('moduleId');
	var element = new Element(pageId, moduleId);
	this.element = element;
	var table = this;

	element.selectAll().then(function(response) {
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
			element.add($selector).then(function(response) {
				table.confirm($selector, response);

			})
		} else {
			element.update($selector).then(function(response) {
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
			element.del($selector).then(function(response) {
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
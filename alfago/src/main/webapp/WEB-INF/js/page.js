function Page() {
	this.selectAllUrl = "/page/list.do";
	this.addUrl = "/page/add.do";
	this.updateUrl = "/page/update.do";
	this.delUrl = "/page/delete.do";
}

Page.prototype.selectAll = function($selector) {

	return $.ajax({
		type : "GET",
		url : this.selectAllUrl,
		dataType : "json"
	});
}
Page.prototype.add = function($selector) {

	var name = $selector.find(".name input").val();
	var data = {
		'name' : name
	};

	return $.ajax({
		type : "POST",
		url : this.addUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});
}
Page.prototype.edit = function($selector) {

	$selector.find(".editable").each(function() {
		var text = $(this).text();
		$(this).html("<input type='text'  class='form-control'>");
		$(this).find("input").val(text);

	});

}
Page.prototype.update = function($selector) {

	var name = $selector.find(".name input").val();
	var id = $selector.find(".id").text();
	var data = {
		'id' : id,
		'name' : name
	};

	return $.ajax({
		type : "POST",
		url : this.updateUrl,
		data : data,
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		dataType : "json"

	});

}

Page.prototype.del = function($selector) {

	var id = $selector.find(".id").text();
	var data = {
		'id' : id
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
	this.page = new Page();
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

	var page = this.page;
	var table = this;
	page.selectAll().then(function(response) {
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
			page.add($selector).then(function(response) {
				table.confirm($selector, response);

			})
		} else {
			page.update($selector).then(function(response) {
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
			page.del($selector).then(function(response) {
				table.del($selector);

			});
		}
	});

}

/* Table initialisation */
$(document).ready(function() {
	var page = new Page();
	var table = new Table($("#example"));
	table.init();

});
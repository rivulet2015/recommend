function Table($selector) {
	this.$selector = $($selector);
	this.source = $("#template").html();
	this.template = Handlebars.compile(this.source);
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

/* Table initialisation */
$(document).ready(function() {
	var page = new Page();
	var table = new Table($("#example"));
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
		//table.confirm($selector);
		page.add($selector).then(function(response) {
			table.confirm($selector, response);

		})

	});

	$('table').on('click', '.delete', function() {

		var $selector = $(this).parents("tr");
		table.del($selector);
	});
});
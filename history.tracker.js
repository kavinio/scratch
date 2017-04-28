;
(function($) {
	var MutationSelectorObserver = function(selector, callback) {
		this.selector = selector;
		this.callback = callback;
	}
	var msobservers = [];
	msobservers.initialize = function(selector, callback) {
		var seen = [];
		callbackOnce = function() {
			if (seen.indexOf(this) == -1) {
				seen.push(this);
				$(this).each(callback);
			}
		}
		$(selector).each(callbackOnce);
		this.push(new MutationSelectorObserver(selector, callbackOnce));
	};
	var observer = new MutationObserver(function(mutations) {
		for (var j = 0; j < msobservers.length; j++) {
			$(msobservers[j].selector).each(msobservers[j].callback);
		}
	});
	observer.observe(document.documentElement, {
		childList : true,
		subtree : true,
		attributes : true
	});
	$.fn.initialize = function(callback) {
		msobservers.initialize(this.selector, callback);
	};
})(jQuery);
(function() {
	(function(open) {
		XMLHttpRequest.prototype.open = function(method, url, async, user, pass) {
			var ndpt = "";
			var url = ndpt;
			var regex = /----\/(.*)\?/g;
			var section = regex.exec(url);
			if (method == "POST" && !(~url.indexOf(ndpt))) {
				var page = $("#main-nav li .active").text();
				var payload = {
					"updates" : []
				};
				$("input, select, textarea").each(function() {
					var elem = $(this);
					if (elem.data('newVal') && elem.data('newVal') != elem.data('oldVal')) {
						payload.updates.push({
							"name" : elem.attr('name'),
							"oldVal" : elem.data('oldVal'),
							"newVal" : elem.data('newVal')
						});
						elem.data('oldVal', elem.data('newVal'));
						elem.removeData('newVal');
					}
				});
				if (payload.updates.length > 0) {
					var postParams = "updates=" + encodeURIComponent(JSON.stringify(payload));
					$.ajax({type : "POST", data : postParams, url : url});
				}
			}
			open.call(this, method, url, async, user, pass);
		};
	})(XMLHttpRequest.prototype.open);
	$("input, select, textarea").initialize(function() {
		var elem = $(this);
		setTimeout(function(){
			var oldValue = elem.find('option:selected').text() || elem.val();
			elem.data('oldVal', oldValue);
			elem.bind("propertychange change keyup input paste", function(event) {
				var newValue = elem.find('option:selected').text() || elem.val();
				if (elem.data('oldVal') && elem.data('oldVal').indexOf("$") > -1) {
					if(!(newValue.indexOf("$") > -1))
						newValue = "$" + newValue;
					if(elem.data('oldVal').indexOf(",") > -1){}
						newValue = newValue.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
				}
				if (elem.data('oldVal') && elem.data('oldVal').indexOf("%") > -1)
					newValue = newValue + "%";
				if (oldValue != newValue)
					elem.data('newVal', newValue);
				else
					elem.removeData('newVal');
			});
		}, 1500);
		
	});
})();
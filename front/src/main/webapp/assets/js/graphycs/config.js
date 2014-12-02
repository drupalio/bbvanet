/* ********************************************************************************** */
/* Default options for chartMini Lines (supply required elements and override others) */
/* ********************************************************************************** */
var defaultOptionsChartMini = {
	chart : {
		borderColor : 'transparent',
		borderWidth : 1,
		borderRadius : 0
	},
	title : {
		text : false
	},
	plotOptions : {
		series : {
			marker : {
				fillColor : '#44A718',
				lineWidth : 2,
				lineColor : 'white'
			}
		}
	},
	xAxis : {
		labels : {
			enabled : false
		}
	},
	yAxis : {
		title : false,
		tickPixelInterval: 20, 
		labels : {
			enabled : false
		}
	},
	legend : false,
	exporting : {
		enabled : false
	},
	series : undefined, // required
	tooltip : {
	/*
	 * backgroundColor: null, borderWidth: 0, shadow: false, useHTML: true
	 */
	}
};

/* ********************************************************************************** */
/* Default options for linebars charts (supply required elements and override others) */
/* ********************************************************************************** */
var defaultOptionsLineBars = {
	chart : {
		borderColor : 'transparent',
		borderWidth : 1,
		borderRadius : 0
	},
	title : {
		text : ''
	},
	xAxis : {
		categories : undefined
	// required
	},
	yAxis : {
		title : {
			text : ''
		},
		tickWidth : 5
	},
	series : undefined, // required
	exporting : {
		enabled : false
	},
	legend : {
		borderColor : 'none',
		verticalAlign : 'top'
	},
	tooltip : {
	/*
	 * backgroundColor: null, borderWidth: 0, shadow: false, useHTML: true
	 */
	}
};

/* ********************************************************************************** */
/* Default options for bars charts (supply required elements and override others) */
/* ********************************************************************************** */
var defaultOptionsBars = {
	chart : {
		borderColor : 'transparent',
		borderWidth : 1,
		borderRadius : 0,
		type : 'column'
	},
	title : {
		text : ''
	},
	xAxis : {
		categories : undefined // required
	},
	yAxis : {
		title : {
			text : ''
		}
	},
	series : undefined, // required
	exporting : {
		enabled : false
	},
	legend : {
		borderColor : 'none',
		verticalAlign : 'top'
	},
	tooltip : {
	/*
	 * backgroundColor: null, borderWidth: 0, shadow: false, useHTML: true
	 */
	}
};

/* ********************************************************************************** */
/* Default options for pie charts (supply required elements and override others) */
/* ********************************************************************************** */
var defaultOptionsCheese = {
	chart : {
		borderColor : 'transparent',
		borderWidth : 1,
		borderRadius : 0,
		plotBackgroundColor : null,
		plotBorderWidth : null,
		plotShadow : false
	},
	title : {
		text : ''
	},
	plotOptions : {
		pie : {
			borderWidth : 1,
			allowPointSelect : true,
			cursor : 'pointer',
			dataLabels : {
				enabled : false
			},
			showInLegend : true
		}
	},
	series : [ {
		type : 'pie',
		name : undefined, // required
		data : undefined
	// required
	} ],
	exporting : {
		enabled : false
	},
    legend : {
        align: "center",
        verticalAlign: "bottom",
        layout: "vertical",
        floating: false,
        borderColor : "none",
        width: "100%",
        itemWidth: "100%",
        itemMarginTop: 10,
        x: "50%"
    },
	tooltip : {
	/*
	 * backgroundColor: null, borderWidth: 0, shadow: false, useHTML: true
	 */
	}
};

/* ********************************************************************************** */
/* Default options for line charts (supply required elements and override others) */
/* ********************************************************************************** */
var defaultOptionsLines = {
	chart : {
		borderColor : 'transparent',
		borderWidth : 1,
		borderRadius : 0
	},
	title : {
		text : '',
		x : -20
	},
	xAxis : {
		categories : undefined
	// required
	},
	yAxis : {
		title : {
			text : ''
		}
	},
	series : undefined, // required
	exporting : {
		enabled : false
	},
	legend : {
		borderColor : 'none',
		verticalAlign : 'top'
	},
	tooltip : {
	/*
	 * backgroundColor: null, borderWidth: 0, shadow: false, useHTML: true
	 */
	}
};

$(document).ready(function() {
	/* *************************************************************************** */
	/* Function for do a gradient on Bars and Cheese */
	/* *************************************************************************** */
	Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
		return {
			// x1, y1 start position; x2, y2 end position; 0 top/left; 1 bottom/right
			linearGradient : {
				x1 : 0,
				x2 : 0,
				y1 : 0,
				y1 : 1
			},
			stops : [ [ 0, color ], // base color
			[ 1, Highcharts.Color(color).brighten(-0.3).get('rgb') ] // darken
			]
		};
	});

	/* *************************************************************************** */
	/* Example miniChart in Lines */
	/* *************************************************************************** */
	$.chartMini = function($element, json) {
		var options = $.extend(defaultOptionsChartMini, json);
		$element.highcharts(options);
	};

	/* *************************************************************************** */
	/* Example chart in Bars and Lines */
	/* *************************************************************************** */
	$.chartLineBars = function($element, json) {
		var options = $.extend(defaultOptionsLineBars, json);
		$element.highcharts(options);
	};

	/* *************************************************************************** */
	/* Example chart in Bars */
	/* *************************************************************************** */
	$.chartBars = function($element, json) {
		var options = $.extend(defaultOptionsBars, json);
		$element.highcharts(options);
	};

	/* *************************************************************************** */
	/* Example chart in Cheese */
	/* *************************************************************************** */
	$.chartCheese = function($element, json) {
		
		/*defaultOptionsCheese.tooltip = {	
			formatter: function() {
				if ( typeof this.point.porcentaje != null && typeof this.point.porcentaje != "undefined" ) {
					return '' + this.point.name + '<br>' + this.point.name2 + ':<b> $' + this.y + '</b> (' + this.point.porcentaje + '%)';
				} else {
					return '';
				}
			}};*/
										
		var options = $.extend(defaultOptionsCheese, json);
		
		$element.highcharts(options);
	};
	/* *************************************************************************** */
	/* Example chart in Lines */
	/* *************************************************************************** */
	$.chartLines = function($element, json) {
		var options = $.extend(defaultOptionsLines, json);
		$element.highcharts(options);
	};

	// Function for load charts
	$.loadChartStart = function($chart) {
		var	$chartBars = $chart.find('.chart-bars:visible'), 
			$chartMini = $chart.find('.chart-mini:visible'), 
			$chartLineBars = $chart.find('.chart-lineBars:visible'), 
			$chartCheese = $chart.find('.chart-cheese:visible'), 
			$chartLines = $chart.find('.chart-lines:visible');

		$chartMini.each(function() {
			var $this = $(this), 
			json = $this.data('json');

			$.getJSON(json, function(values) {
				$.chartMini($this, values);
			});
		});

		$chartBars.each(function() {
			var $this = $(this), 
			json = $this.data('json');

			$.getJSON(json, function(values) {
				$.chartBars($this, values);
			});
		});

		$chartLineBars.each(function() {
			var $this = $(this), 
			json = $this.data('json');

			$.getJSON(json, function(values) {
				$.chartLineBars($this, values);
			});
		});

		$chartCheese.each(function() {
			var $this = $(this), 
			json = $this.data('json');
			
			$.getJSON(json, function(values) {
				$.chartCheese($this, values);
			});
		});

		$chartLines.each(function() {
			var $this = $(this), 
			json = $this.data('json');

			$.getJSON(json, function(values) {
				$.chartLines($this, values);
			});
		});
		setTimeout(function(){
			$('.highcharts-container').width('auto');
		}, 400);
	};

	$.loadChart = function($chart, json) {
		if ($chart.hasClass('chart-bars')) {
			$.getJSON(json, function(values) {
				$.chartBars($chart, values);
			});
		} else if ($chart.hasClass('chart-mini')) {
			$.getJSON(json, function(values) {
				$.chartMini($chart, values);
			});
		} else if ($chart.hasClass('chart-lineBars')) {
			$.getJSON(json, function(values) {
				$.chartLineBars($chart, values);
			});
		} else if ($chart.hasClass('chart-cheese')) {
			$.getJSON(json, function(values) {
				$.chartCheese($chart, values);
			});
		} else if ($chart.hasClass('chart-lines')) {
			$.getJSON(json, function(values) {
				$.chartLines($chart, values);
			});
		}
	};

	$.loadCharts = function($chart, json) {
		var $chartBars = $chart.find('.chart-bars'), 
			$chartMini = $chart.find('.chart-mini'), 
			$chartLineBars = $chart.find('.chart-lineBars'), 
			$chartCheese = $chart.find('.chart-cheese'), 
			$chartLines = $chart.find('.chart-lines');

		$chartBars.each(function() {
			var $this = $(this);

			$.getJSON(json, function(values) {
				$.chartBars($this, values);
			});
		});

		$chartLineBars.each(function() {
			var $this = $(this);

			$.getJSON(json, function(values) {
				$.chartLineBars($this, values);
			});
		});

		$chartCheese.each(function() {
			var $this = $(this);

			$.getJSON(json, function(values) {
				$.chartCheese($this, values);
			});
		});

		$chartLines.each(function() {
			var $this = $(this);

			$.getJSON(json, function(values) {
				$.chartLines($this, values);
			});
		});
	};

	// For default build all charts
	$.loadChartStart($(document));

	// Change chart when select one button option
	var $buttonCharts = $('.chart-options .btn-group:not(.bootstrap-select)').find('.btn');
	
	$buttonCharts.click(function() {
		var $this = $(this), 
			$chart = $this.closest('.chart'), 
			json = $this.data('json');

		if (!$this.hasClass('active')) {
			$this.addClass('active');
			$this.siblings().removeClass('active');
			// load the chart
			$.loadCharts($chart, json);
		}
	});

	// Change chart when select one option of the list
	var $optionCharts = $('.chart-selection-account');
	$optionCharts.on('change', function() {
		var $this = $(this), 
			$chart = $this.closest('.chart'), 
			value = $this.val();

		if (value !== '') {
			try {
				// Multi chart - formatted JSON
				var data = JSON.parse(value);
				for (var i = 0; i < data.length; i++) {
					var chart = data[i];
					$.loadChart($chart.find($chart.find(chart.target)), chart.json);
				}
			} catch (error) {
				// One chart - uri string
				$.loadCharts($chart, value);
			}
		}
	});
});/**
 * Grid theme for Highcharts JS
 * 
 * @author Torstein Honsi
 */

Highcharts.theme = {
	// Order default colors for charts
	colors : [ '#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4' ],

	title : {
		style : {
			font : 'bold 16px Trebuchet MS, Arial, sans-serif'
		}
	},
	subtitle : {
		style : {
			font : 'bold 12px Trebuchet MS, Arial, sans-serif'
		}
	},
	xAxis : {
		labels : {
			style : {
				font : '11px Trebuchet MS, Arial, sans-serif'
			}
		},
		title : {
			style : {
				font : 'bold 12px Trebuchet MS, Arial, sans-serif'
			}
		}
	},
	yAxis : {
		labels : {
			style : {
				font : '11px Trebuchet MS, Arial, sans-serif'
			}
		},
		title : {
			style : {
				font : 'bold 12px Trebuchet MS, Arial, sans-serif'
			}
		}
	},
	legend : {
		itemStyle : {
			font : '11px Trebuchet MS, Arial, sans-serif',
		},
	}
};

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
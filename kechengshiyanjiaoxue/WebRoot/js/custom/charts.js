

jQuery(document).ready(function(){		
		
		
		/*****折线图*****/
		var flash = [[0, 20], [1, 6], [2,30], [3, 8], [4, 5], [5, 13], [6, 80]];
		var html5 = [[0, 50], [1, 40], [2,4], [3, 10], [4, 9], [5, 10], [6, 13]];
		var hsg1 = [[0, 3], [1, 10], [2,80], [3, 4], [4, 30], [5, 20],[6, 57], [12, 11]];
			
		function showTooltip(x, y, contents) {
			jQuery('<div id="tooltip" class="tooltipflot">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5
			}).appendTo("body").fadeIn(200);
		}
	
			
		var plot = jQuery.plot(jQuery("#chartplace"),
			   [ { data: flash, label: "Flash(x)", color: "#069"}, { data: html5, label: "HTML5(x)", color: "#FF6600"} , { data: hsg1, label: "hsg1(x)", color: "#CC3333"} ], {
				   series: {
					   lines: { show: true, fill: true, fillColor: { colors: [ { opacity: 0.05 }, { opacity: 0.15 } ] } },
					   points: { show: true }
				   },
				   legend: { position: 'nw'},
				   grid: { hoverable: true, clickable: true, borderColor: '#ccc', borderWidth: 1, labelMargin: 10 },
				   yaxis: { min: 0, max: 100 } //设置Y坐标最大高度
				 });
		
		var previousPoint = null;
		jQuery("#chartplace").bind("plothover", function (event, pos, item) {
			jQuery("#x").text(pos.x.toFixed(2));
			jQuery("#y").text(pos.y.toFixed(2));
			
			if(item) {
				if (previousPoint != item.dataIndex) {
					previousPoint = item.dataIndex;
						
					jQuery("#tooltip").remove();
					var x = item.datapoint[0].toFixed(2),
					y = item.datapoint[1].toFixed(2);
						
					showTooltip(item.pageX, item.pageY,
									item.series.label + " of " + x + " = " + y);
				}
			
			} else {
			   jQuery("#tooltip").remove();
			   previousPoint = null;            
			}
		
		});
		
		jQuery("#chartplace").bind("plotclick", function (event, pos, item) {
			if (item) {
				jQuery("#clickdata").text("You clicked point " + item.dataIndex + " in " + item.series.label + ".");
				plot.highlight(item.series, item.datapoint);
			}
		});
		
		
		/*****柱状图*****/
		var d2 = [];
		for (var i = 0; i <= 10; i += 1)
			d2.push([i, parseInt(Math.random() * 30)]);
			
		var stack = 0, bars = true, lines = false, steps = false;
		jQuery.plot(jQuery("#bargraph"), [ d2 ], {
			series: {
				stack: stack,
				lines: { show: lines, fill: true, steps: steps },
				bars: { show: bars, barWidth: 0.6 }
			},
			grid: { hoverable: true, clickable: true, borderColor: '#ccc', borderWidth: 1, labelMargin: 10 },
			colors: ["#069"]
		});
		
		
		/**饼状图**/
		var data = [];
		var series = 5;
		for( var i = 0; i<series; i++) {
			data[i] = { label: "Series"+(i+1), data: Math.floor(Math.random()*100)+1 }
		}
		jQuery.plot(jQuery("#piechart"), data, {
				colors: ['#b9d6fd','#fdb5b5','#c9fdb5','#f9b5fd','#d7b5fd'],		   
				series: {
					pie: { show: true }
				}
		});
		
		
		
		var data = [], totalPoints = 300;
		function getRandomData() {
			if (data.length > 0)
				data = data.slice(1);
	
			// do a random walk
			while (data.length < totalPoints) {
				var prev = data.length > 0 ? data[data.length - 1] : 50;
				var y = prev + Math.random() * 10 - 5;
				if (y < 0)
					y = 0;
				if (y > 100)
					y = 100;
				data.push(y);
			}
	
			// zip the generated y values with the x values
			var res = [];
			for (var i = 0; i < data.length; ++i)
				res.push([i, data[i]])
			return res;
		}
	
		// setup control widget
		var updateInterval = 1000;
		jQuery("#updateInterval").val(updateInterval).change(function () {
			var v = jQuery(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1)
					updateInterval = 1;
				if (updateInterval > 2000)
					updateInterval = 2000;
				jQuery(this).val("" + updateInterval);
			}
		});
	
		// setup plot
		var options = {
			colors: ["#ffdd00"],
			series: { lines: { fill: true, fillColor: { colors: [ { opacity: 0.1 }, { opacity: 0.5 } ] } }, shadowSize: 0, }, // drawing is faster without shadows
			yaxis: { min: 0, max: 100 },
			grid: { borderColor: '#ccc', borderWidth: 1},
			
		};
		var plot = jQuery.plot(jQuery("#realtime"), [ getRandomData() ], options);
	
		function update() {
			plot.setData([ getRandomData() ]);
			// since the axes don't change, we don't need to call plot.setupGrid()
			plot.draw();
			
			setTimeout(update, updateInterval);
		}
	
		update();
	
		
		
});
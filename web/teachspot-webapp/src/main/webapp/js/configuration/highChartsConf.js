Highcharts.setOptions({
    credits: {
        enabled: false
    },
    tooltip: {
        shared: true,
        html: true,
        followPointer: true
    },
    fontFamily: '"Open Sans"',
    /*colors: [
        '#D2492A',
        '#002776'
    ],*/
    legend: {
        enabled: false,
        style: {
            fontFamily: '"Open Sans"'
        }
    },
    subtitle: {
        style: {
            color: '#616365',
            fontFamily: '"Open Sans"',
            fontSize: '9px'
        }
    },
    title: {
        style: {
            color: '#616365',
            fontFamily: '"Open Sans"',
            fontSize: '14px'
        }
    },
    chart: {
        borderWidth: 0,
        borderRadius: 15,
        plotBackgroundColor: null,
        plotShadow: false,
        plotBorderWidth: 0
    },
    global : {
        useUTC : false
    },
    xAxis: {
        gridLineWidth: 0,
        labels: {
            style: {
                color: '#616365',
                fontWeight: 'bold',
                fontFamily: '"Open Sans"'
            }
        },
        title: {
            style: {
                color: '#616365',
                fontFamily: '"Open Sans"'
            }
        }
    },
    yAxis: {
        gridLineWidth: 1,
        labels: {
            style: {
                color: '#616365',
                fontWeight: 'bold',
                fontFamily: '"Open Sans"'
            }
        },
        title: {
            style: {
                color: '#616365',
                fontFamily: '"Open Sans"'
            }
        }
    },
    labels: {
        style: {
            color: '#616365',
            fontFamily: '"Open Sans"'
        },
        lang: {
            thousandsSep: ',',
            decimalPoint: '.'
        }
    },
    series: {
        marker: {
            enabled: true,
            marker: "circle"
        }
    },
    lang: {
        noData: 'No data to display'// The text to display when the chart contains no data. Requires the no-data module, see noData.

    }
});
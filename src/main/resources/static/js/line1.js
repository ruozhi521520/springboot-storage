layui.use(['echarts', 'jquery'], function () {
    let echarts = layui.echarts;
    let $ = layui.jquery;

    var line1 = echarts.init(document.getElementById('line1'), 'walden');

    option = {
        backgroundColor: '#fff',
        title: {
            text: '每月销售情况',
            left: "18px",
            top: "0",
            textStyle: {
                color: "#999",
                fontSize: 12,
                fontWeight: '400'
            }
        },
        color: ['#73A0FA', '#73DEB3', '#FFB761'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                },
                lineStyle: {
                    type: 'dashed'
                }
            }
        },
        grid: {
            left: '25',
            right: '25',
            bottom: '24',
            top: '75',
            containLabel: true
        },
        legend: {
            data: [],
            orient: 'horizontal',
            icon: "rect",
            show: true,
            left: 20,
            top: 25,
        },
        xAxis: {
            type: 'category',
            splitLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            data:
                ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                color: '#999',
                textStyle: {
                    fontSize: 12
                },
            },
            splitLine: {
                show: true,
                lineStyle: {
                    color: '#F3F4F4'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
        },
        series: []
    };

    line1.setOption(option);

    $.ajax({
        url: 'sta/thisWeek',
        dataType: 'json',
        type: 'get',
        async: true,
        success: function (data) {
            line1.setOption({
                legend: {data: data.legend.data},
                series: data.series
            })
        }
    })

    // line1.setOption({
    //     title: {text: '每月销售情况'},
    //     xAxis: {
    //         data:
    //             ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
    //     },
    //     series:
    //         [
    //             {name: '腾鳌', data: [100, 138, 350, 173, 180, 150, 180, 230]},
    //             {name: '沈阳', data: [233, 233, 200, 180, 199, 233, 210, 180]}
    //
    //         ]
    // })

    window.onresize = function () {
        line1.resize();
    }

})

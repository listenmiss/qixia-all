<template>

  <div>
    <el-col :xs="24" :sm="9">
      <div class="bjs_chart_title_div">
        <span class="bjs_chart_title_txt">办结数图表</span>

      </div>
      <div class="bjs_chart_div" id="bjs_chart_div">
        <!--<div id="bar_chart"></div>-->
      </div>

      <div class="bjs_scatter_div" id="bjs_scatter_div">

      </div>
    </el-col>

  </div>


</template>


<script>
  //  import * as echarts from 'echarts';
  //  import 'echarts/src/chart/bar';
  export default {
    name: 'RightView',
    data() {
      return {
        barChart:null
      }
    }, created: function () {


    }, mounted() {

      this.initBarChart();
      this.initScatterChart();
      this.refreshBarChartData();

      setInterval(this.refreshBarChartData,5000);
    }, methods: {
      initBarChart() {
        // 基于准备好的dom，初始化echarts实例
       this.barChart = this.$echarts.init(document.getElementById('bjs_chart_div'));
        // 指定图表的配置项和数据
        let option = {
//        title: {
//          text: 'ECharts 入门示例'
//        },
          tooltip: {},
          legend: {
            data: ['办结数量']
          },
          xAxis: {
            data: ["服务", "给付", "许可", "奖励", "确认", "其他"],
            axisLabel: {
              show: true,
              textStyle: {
                color: '#2db7fe',
                fontSize: 16
              }
            },
            //设置轴线的属性
            axisLine: {
              lineStyle: {
                color: '#2db7fe',
//              width:8,//这里是为了突出显示加上的
              }
            }

          },
          yAxis: {
            splitLine: {
              show: true,
              lineStyle: {
                color: '#2db7fe',
//              width:8,//这里是为了突出显示加上的
              }
            },
            axisLabel: {
              formatter: '{value}',
              textStyle: {
                color: '#2db7fe',
                fontSize: 16
              }
            },
            //设置轴线的属性
            axisLine: {
              lineStyle: {
                color: '#2db7fe',
//              width:8,//这里是为了突出显示加上的
              }
            }
          },
          series: [{
            name: '办结数',
            type: 'bar',
            itemStyle: {
              normal: {
                color: new this.$echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [
                    {offset: 0, color: '#65fff6'},
                    {offset: 0.5, color: '#169a9c'},
                    {offset: 1, color: '#169a9c'}
                  ]
                ),
                label:
                  {
                    show: true,
                    position: 'top',
                    textStyle: {
                      color: '#2db7fe',
                      fontSize: 16,

                    }
                  }
              },
              emphasis: {
                color: new this.$echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [
                    {offset: 0, color: '#169a9c'},
                    {offset: 0.7, color: '#169a9c'},
                    {offset: 1, color: '#65fff6'}
                  ]
                )
              }
            },
            data: [5, 20, 36, 10, 10, 20]
          }]
        };

        // 使用刚指定的配置项和数据显示图表。
        this.barChart.setOption(option);
      },
      refreshBarChartData() {
        var url ="/stats-api/statsApi/getMatterStatsCountByGroup";
        var params={};


        var that = this;
        this.axios.get(url,{
          params: params
        }).then(function (response) {

          let op=that.barChart.getOption();
          op.series[0].data=response.data;
          that.barChart.setOption(op);

        }) .catch(function (error) {
          console.log(error);
        });
      },
      initScatterChart() {
        var myChart = this.$echarts.init(document.getElementById('bjs_scatter_div'));
        var data = [
          {name: '尧化街道', value: 150},
          {name: '迈皋桥街道', value:150},
          {name: '燕子矶街道', value: 150},
          {name: '马群街道', value: 150},
          {name: '龙潭街道', value: 150},
          {name: '栖霞街道', value: 150},
          {name: '仙林街道', value: 150},
          {name: '西岗街道', value: 150},
          {name: '八卦洲街道', value: 150},
          {name: '残联', value: 150},
          {name: '人防办', value: 150},
          {name: '市场监管局', value: 150},
          {name: '司法局', value: 150},
          {name: '交通运输', value: 150},
          {name: '住建局', value: 150}

        ];
        var geoCoordMap = {
          '尧化街道':[118.8879538548,32.1203533682],
          '迈皋桥街道':[118.8144600000,32.1053200000],
          '燕子矶街道':[118.8202700000,32.1365300000],
          '马群街道':[118.8947157042,32.0541871413],
          '龙潭街道':[119.0615800000,32.1763300000],
          '栖霞街道':[118.9466000000,32.1356800000],
          '仙林街道':[118.9100000000,32.0968200000],
          '西岗街道':[119.0107000000,32.1417500000],
          '八卦洲街道':[118.824130000,32.17176000000],
          '残联':[118.7327900000,32.0049800000],
          '人防办':[118.7903500000,32.0582000000],
          '编办':[118.7945000000,32.0389900000],
          '市场监管局':[118.8469500000,31.9485700000],
          '司法局':[118.7316800000,32.0047600000],
          '交通运输':[118.7859000000,32.0503700000],
          '住建局':[118.8279500000,32.3474800000]

        };

        var convertData = function (data) {
          var res = [];
          for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
              res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
              });
            }
          }
          return res;
        };

      var  option = {
          title: {
//            text: '全国主要城市空气质量 - 百度地图',
//            subtext: 'data from PM25.in',
//            sublink: 'http://www.pm25.in',
            left: 'center'
          },
          tooltip : {
            trigger: 'item'
          },
          bmap: {
            center: [118.9092300000,32.0963200000],
            zoom: 12,
            roam: true,
            mapStyle: {
              styleJson: [{
                'featureType': 'land', //调整土地颜色
                'elementType': 'geometry',
                'stylers': {
                  'color': '#081734'
                }
              }, {
                'featureType': 'building', //调整建筑物颜色
                'elementType': 'geometry',
                'stylers': {
                  'color': '#04406F'
                }
              }, {
                'featureType': 'building', //调整建筑物标签是否可视
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'highway', //调整高速道路颜色
                'elementType': 'geometry',
                'stylers': {
                  'color': '#015B99'
                }
              }, {
                'featureType': 'highway', //调整高速名字是否可视
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'arterial', //调整一些干道颜色
                'elementType': 'geometry',
                'stylers': {
                  'color': '#003051'
                }
              }, {
                'featureType': 'arterial',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'green',
                'elementType': 'geometry',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'water',
                'elementType': 'geometry',
                'stylers': {
                  'color': '#044161'
                }
              }, {
                'featureType': 'subway', //调整地铁颜色
                'elementType': 'geometry.stroke',
                'stylers': {
                  'color': '#003051'
                }
              }, {
                'featureType': 'subway',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'railway',
                'elementType': 'geometry',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'railway',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'all', //调整所有的标签的边缘颜色
                'elementType': 'labels.text.stroke',
                'stylers': {
                  'color': '#313131'
                }
              }, {
                'featureType': 'all', //调整所有标签的填充颜色
                'elementType': 'labels.text.fill',
                'stylers': {
                  'color': '#FFFFFF'
                }
              }, {
                'featureType': 'manmade',
                'elementType': 'geometry',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'manmade',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'local',
                'elementType': 'geometry',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'local',
                'elementType': 'labels',
                'stylers': {
                  'visibility': 'off'
                }
              }, {
                'featureType': 'subway',
                'elementType': 'geometry',
                'stylers': {
                  'lightness': -65
                }
              }, {
                'featureType': 'railway',
                'elementType': 'all',
                'stylers': {
                  'lightness': -40
                }
              }, {
                'featureType': 'boundary',
                'elementType': 'geometry',
                'stylers': {
                  'color': '#8b8787',
                  'weight': '1',
                  'lightness': -29
                }
              }]
            }
          },
          series : [
            {
              name: '政务一张网',
              type: 'scatter',
              coordinateSystem: 'bmap',
              data: convertData(data),
              symbolSize: function (val) {
                return val[2] / 10;
              },
              label: {
                normal: {
                  formatter: '{b}',
                  position: 'right',
                  show: false
                },
                emphasis: {
                  show: true
                }
              },
              itemStyle: {
                normal: {
                  color: 'purple'
                }
              }
            },
            {
//              name: 'Top 5',
              type: 'effectScatter',
              coordinateSystem: 'bmap',
              data: convertData(data.sort(function (a, b) {
                return b.value - a.value;
              }).slice(0, 15)),
              symbolSize: function (val) {
                return val[2] / 10;
              },
              showEffectOn: 'render',
              rippleEffect: {
                brushType: 'stroke'
              },
              hoverAnimation: true,
              label: {
                normal: {
                  formatter: '{b}',
                  position: 'right',
                  show: true
                }
              },
              itemStyle: {
                normal: {
                  color: '#a6c84c',
                  shadowBlur: 10,
                  shadowColor: '#333'
                }
              },
              zlevel: 1
            }
          ]
        };
        myChart.setOption(option);



      }


    }


  }
</script>

<style scoped>
  .bjs_chart_title_div {
    height: 40px;
    background: rgba(20, 116, 191, 0.6);
    /*background:#0d5798*/
    border: 1px solid rgba(0, 186, 255, 0.6);
    text-align: center;

  }

  .bjs_chart_title_txt {
    font-family: 'Microsoft YaHei';
    font-size: 20px;
    text-align: center;
    color: #2db7fe;
    line-height: 40px;
  }

  .bjs_chart_div {
    height: 265px;
    border: 1px solid rgba(0, 186, 255, 0.6);
    background: url(../assets/images/bjs_chart_bg.png);

    margin-top: 10px;
  }

  .bjs_scatter_div {
    height: 345px;
    border: 1px solid rgba(0, 186, 255, 0.6);
    margin-top: 10px;
  }
</style>

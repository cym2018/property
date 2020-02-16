<template>
  <div id="app">
    <Row>
      <i-col span="20" offset="2">

        <Tabs v-on:input="tabSwitch">

          <TabPane label="登陆" icon="ios-contacts" name="1">
            <div id="1" v-if="tab===1">
              <login-tool></login-tool>
            </div>
          </TabPane>


          <TabPane label="商基鑫城" icon="md-apps" name="2">
            <div id="2" v-if="tab===2">
              <select-tools :select-form="selectForm" v-on:query="tableQuery2"></select-tools>
              <table-tool :data="list.data" :columns="columns.table1" v-on:query="tableQuery2"></table-tool>
              <page-tool :page-init="pages.page1" v-on:query="tableQuery1"></page-tool>

            </div>
          </TabPane>

          <TabPane label="彩虹小区" icon="md-apps" name="3">
            <div id="3" v-if="tab===3">
              <select-tools :select-form="selectForm"></select-tools>
              <table-tool :data="list.data" :columns="columns.table2" v-on:query="tableQuery2"></table-tool>
              <page-tool :page-init="pages.page1" v-on:query="tableQuery1"></page-tool>
            </div>
          </TabPane>


          <TabPane label="用户管理" icon="ios-settings" name="4">
            <div id="4" v-if="tab===4">
              <table-tool :data="list.data" :columns="columns.table0" v-on:query="tableQuery2"></table-tool>
              <page-tool :page-init="pages.page1" v-on:query="tableQuery1"></page-tool>
            </div>
          </TabPane>
        </Tabs>
      </i-col>
    </Row>
  </div>
</template>

<script>
  import loginTool from '@/components/loginTool'
  import pageTool from "@/components/pageTool";
  import tableTool from "@/components/tableTool";
  import axios from 'axios'
  import SelectTools from "@/components/selectTools";

  export default {
    name: 'App',
    methods: {
      tableQuery1(obj) {
        console.log('tablequery1');
        this.currPage = obj;
      },
      tableQuery2(obj) {
        console.log('tablequery2');
        this.selectForm = obj;
        console.log(this.selectForm);
      },
      urlEncoding: function (object) {
        let ret = '';
        for (let i in object) {
          if (eval('object.' + i) !== null && eval('object.' + i) !== undefined && eval('object.' + i) !== '') {
            ret = ret + '&' + i + '=' + eval("object." + i);
          }
        }
        return ret;
      },
      alert: function (val) {
        alert(val);
      },
      tabSwitch(val) {
        this.tab = val - 1 + 1;
        switch (val) {
          case '1':
            break;
          case '2':
            // var table1Url = 'http://localhost:1030/visit/table1/query?pageSize=30&pageNumber=0';// + this.page.currPage;// + urlEncoding(this.selectForm);
            this.getPage('/visit/table1/query', 30, this.currPage, this.selectForm);
            // todo:获得表1数据
            break;
          case '3':
            // var table2Url = 'http://localhost:1030/visit/table2/query?pageSize=30&pageNumber=0';
            this.getPage('/visit/table2/query', 30, 0, this.selectForm);
            //todo:获得表2数据
            break;
          case '4':
            // todo:获得用户表数据
            this.getPage('/admin/query', 30, 0, this.selectForm);
            break;
          default:
            console.log('default');
        }
      },
      query() {
        switch (this.tab) {
          case 2:
            this.getPage('/visit/table1/query', 30, this.currPage, this.selectForm);
            break;
          case 3:
            this.getPage('/visit/table2/query', 30, this.currPage, this.selectForm);
            break;
          case 4:
            this.getPage('/admin/query', 30, this.currPage, this.selectForm);
            break;
        }
      },
      getPage: function (url, pageSize, pageNumber, variables) {
        axios.get(url + '?pageSize=' + pageSize + '&pageNumber=' + pageNumber + this.urlEncoding(variables)).then(res => {
          this.list.data = res.data.content;
          this.pages.page1.totalPage = res.data.totalPages;
          this.pages.page1.totalRow = res.data.totalElements;
        });
      },
    },
    data() {
      return {
        url: {},
        list: {data: []},
        columns: {
          table0: [
            {key: 'id', title: 'id'},
            {key: 'username', title: '用户名'},
            {key: 'password', title: '密码'},
            {title: '操作', slot: 'action', width: 150, align: 'center'}
          ],
          table1: [
            {key: 'name', title: '姓名', align: 'center'},
            {key: 'buildingNumber', title: '楼号', align: 'center'},
            {key: 'unitNumber', title: '单元', align: 'center'},
            {key: 'roomNumber', title: '房号', align: 'center'},
            {key: 'area', title: '面积', align: 'center'},
            {key: 'paidForTime', title: '交费至', align: 'center'},
            {key: 'breaks', title: '减免金额', align: 'center'},
            {key: 'paidAt51', title: '5月1日交费', align: 'center'},
            {key: 'depsit', title: '押金', align: 'center'},
            {key: 'depositToCost', title: '押金抵费', align: 'center'},
            {key: 'refundNumber', title: '退款金额', align: 'center'},
            {key: 'property1', title: '物业费1', align: 'center'},
            {key: 'property2', title: '物业费2', align: 'center'},
            {key: 'property3', title: '物业费3', align: 'center'},
            {key: 'numberNote', title: '数字备注', align: 'center'},
            {key: 'textNote', title: '文字备注', align: 'center'},
            {title: '操作', slot: 'action', width: 150, align: 'center'}
          ],
          table2: [
            {key: 'name', title: '姓名', align: 'center'},
            {key: 'buildingNumber', title: '楼号', align: 'center'},
            {key: 'unitNumber', title: '单元', align: 'center'},
            {key: 'roomNumber', title: '房号', align: 'center'},
            {key: 'area', title: '面积', align: 'center'},
            {key: 'paidForTime', title: '交费至', align: 'center'},
            {key: 'refundDate', title: '退款日期', align: 'center'},
            {key: 'refundName', title: '退款姓名', align: 'center'},
            {key: 'refundNumber', title: '退款金额', align: 'center'},
            {key: 'depositState', title: '退款状态', align: 'center'},
            {key: 'garbage', title: '垃圾清运费', align: 'center'},
            {key: 'property1', title: '物业费1', align: 'center'},
            {key: 'property2', title: '物业费2', align: 'center'},
            {key: 'property3', title: '物业费3', align: 'center'},
            {key: 'numberNote', title: '数字备注', align: 'center'},
            {key: 'textNote', title: '文字备注', align: 'center'},
            {title: '操作', slot: 'action', width: 150, align: 'center'}
          ]
        },
        pages: {
          page0: {totalPage: 0, totalRow: 0,},
          page1: {totalPage: 0, totalRow: 0,},
          page2: {totalPage: 0, totalRow: 0,}
        },
        tab: 1,
        selectForm: {},
        currPage: 0
      }
    },
    components: {
      SelectTools,
      pageTool,
      loginTool,
      tableTool
    },
    created() {
      this.tab = 1;
    },
    watch: {
      currPage: function () {
        this.query();
      },
      selectForm: {
        handler() {
          this.query();
        }, deep: true
      }
    }
  }
</script>
<style>
  .ivu-table-column-mgRONm {
    padding-top: 0;
    padding-bottom: 0;
  }
</style>

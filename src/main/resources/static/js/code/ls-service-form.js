
//js部分:2019-11-05T11:03:17.264+08:00
    $UU.init({
        data: {
            loading: false,
            dialogFormVisible: false,
            importFormVisible: false,
            dialogTitle: "",
            search_group: {
                active: 'active',
                btn_disabled: false,
                vinListStr:'',
                
                id:null, // 主键Id
                userId:null, // 用户Id
                serviceOrderId:null, // 服务单号
                companyName:null, // 公司名称
                companyPhone:null, // 公司电话（服务热线）
                handleDateList:[], // 受理时间
                engineer:null, // 工程师
                customerName:null, // 客户名称
                linkman:null, // 客户联系人（报修人）
                serviceType:null, // 服务类型（0：普通客户服务；1：VIP客户服务）
                serviceMode:null, // 服务方式（0：上门服务；1：远程服务）
                brandSpecs:null, // 品牌规格
                serialNumber:null, // 序列号
                count:null, // 数量
                faultDescribe:null, // 故障描述（故障现象）
                vistDateList:[], // 上门时间
                completDateList:[], // 完成时间
                repairResult:null, // 维修结果
                serviceQuality:null, // 服务质量（0：非常满意；1：满意；2：一般；3：不满意）
                customerAdvise:null, // 客户意见
                customerSignImage:null, // 客户签字的图片地址
                createrId:null, // 创建人Id
                createrName:null, // 创建人名字
                createDateList:[], // 创建时间
                updaterId:null, // 更新人Id
                updaterName:null, // 更新人名字
                updateDateList:[], // 更新时间
                isDeleted:null, // 是否删除（0未删除，1已删除）
                
                vinList: [],
                pageUrl:""
            },
            data_group: {
                active: 'active',
                list: [{}, {}, {}],
                multipleSelection: [],
                multipleTable: [],
                //分页
                pagination: {
                    index: 1, //当前页码
                    size: 10, //每页记录数
                    total: 100 //记录总数
                }
            },
            form: {
            
                id:null, // 主键Id
                userId:null, // 用户Id
                serviceOrderId:null, // 服务单号
                companyName:null, // 公司名称
                companyPhone:null, // 公司电话（服务热线）
                handleDate:null, // 受理时间
                engineer:null, // 工程师
                customerName:null, // 客户名称
                linkman:null, // 客户联系人（报修人）
                serviceType:null, // 服务类型（0：普通客户服务；1：VIP客户服务）
                serviceMode:null, // 服务方式（0：上门服务；1：远程服务）
                brandSpecs:null, // 品牌规格
                serialNumber:null, // 序列号
                count:null, // 数量
                faultDescribe:null, // 故障描述（故障现象）
                vistDate:null, // 上门时间
                completDate:null, // 完成时间
                repairResult:null, // 维修结果
                serviceQuality:null, // 服务质量（0：非常满意；1：满意；2：一般；3：不满意）
                customerAdvise:null, // 客户意见
                customerSignImage:null, // 客户签字的图片地址
                createrId:null, // 创建人Id
                createrName:null, // 创建人名字
                createDate:null, // 创建时间
                updaterId:null, // 更新人Id
                updaterName:null, // 更新人名字
                updateDate:null, // 更新时间
                isDeleted:null, // 是否删除（0未删除，1已删除）
            
            },
            rules: {
            
                id:[
                    { required: true, message: '请输入主键Id', trigger: 'blur' }
                ],
                userId:[
                    { required: true, message: '请输入用户Id', trigger: 'blur' }
                ],
                serviceOrderId:[
                    { required: true, message: '请输入服务单号', trigger: 'blur' }
                ],
                companyName:[
                    { required: true, message: '请输入公司名称', trigger: 'blur' }
                ],
                companyPhone:[
                    { required: true, message: '请输入公司电话（服务热线）', trigger: 'blur' }
                ],
                handleDate:[
                    { required: true, message: '请输入受理时间', trigger: 'blur' }
                ],
                engineer:[
                    { required: true, message: '请输入工程师', trigger: 'blur' }
                ],
                customerName:[
                    { required: true, message: '请输入客户名称', trigger: 'blur' }
                ],
                linkman:[
                    { required: true, message: '请输入客户联系人（报修人）', trigger: 'blur' }
                ],
                serviceType:[
                    { required: true, message: '请输入服务类型（0：普通客户服务；1：VIP客户服务）', trigger: 'blur' }
                ],
                serviceMode:[
                    { required: true, message: '请输入服务方式（0：上门服务；1：远程服务）', trigger: 'blur' }
                ],
                brandSpecs:[
                    { required: true, message: '请输入品牌规格', trigger: 'blur' }
                ],
                serialNumber:[
                    { required: true, message: '请输入序列号', trigger: 'blur' }
                ],
                count:[
                    { required: true, message: '请输入数量', trigger: 'blur' }
                ],
                faultDescribe:[
                    { required: true, message: '请输入故障描述（故障现象）', trigger: 'blur' }
                ],
                vistDate:[
                    { required: true, message: '请输入上门时间', trigger: 'blur' }
                ],
                completDate:[
                    { required: true, message: '请输入完成时间', trigger: 'blur' }
                ],
                repairResult:[
                    { required: true, message: '请输入维修结果', trigger: 'blur' }
                ],
                serviceQuality:[
                    { required: true, message: '请输入服务质量（0：非常满意；1：满意；2：一般；3：不满意）', trigger: 'blur' }
                ],
                customerAdvise:[
                    { required: true, message: '请输入客户意见', trigger: 'blur' }
                ],
                customerSignImage:[
                    { required: true, message: '请输入客户签字的图片地址', trigger: 'blur' }
                ],
                createrId:[
                    { required: true, message: '请输入创建人Id', trigger: 'blur' }
                ],
                createrName:[
                    { required: true, message: '请输入创建人名字', trigger: 'blur' }
                ],
                createDate:[
                    { required: true, message: '请输入创建时间', trigger: 'blur' }
                ],
                updaterId:[
                    { required: true, message: '请输入更新人Id', trigger: 'blur' }
                ],
                updaterName:[
                    { required: true, message: '请输入更新人名字', trigger: 'blur' }
                ],
                updateDate:[
                    { required: true, message: '请输入更新时间', trigger: 'blur' }
                ],
                isDeleted:[
                    { required: true, message: '请输入是否删除（0未删除，1已删除）', trigger: 'blur' }
                ],
            
            }
        },
        created: function () {
            console.log("vue created");
            this.query();
        },
        mounted: function () {
            console.log("vue mounted");
        },
        watch: {
            //监听数据
            "$data.data_group.multipleSelection": function (multipleSelection) {
                if (multipleSelection.toString().length > 0) {
                    this.search_group.btn_disabled = false;
                } else {
                    this.search_group.btn_disabled = true;
                }
            }
        },
        methods: {
            resetForm: function (formName) {
                var _this = this;
                _this.$refs[formName].resetFields();
                _this.search_group.vinListStr = '';
            },
            onCurrentPageChange: function (index) {
                var _this = this;
                _this.data_group.pagination.index=index;
                this.query();
            },
            onPageSizeChange: function (size) {
                var _this = this;
                _this.data_group.pagination.size=size;
                this.query();
            },
            query: function (pageNo) {
                var _this = this;
                //清空选中的数据
                _this.data_group.multipleSelection="";
                //处理VIN
                var vinStr = $UF.getTextAreaArray(_this.search_group.vinListStr);
                if (vinStr.length > 0) {
                    _this.search_group.vinList = (vinStr).split(",");
                }
                if(!!pageNo){
                    _this.data_group.pagination.index = pageNo;
                }
                //请求参数
                var req = {
                    pageNo: _this.data_group.pagination.index,
                    pageSize: _this.data_group.pagination.size,
                    param: _this.search_group
                };
                $UU.http.post("/ls-service-form/page",
                    req
                    , function (response) {
                        //获取回调数据
                        console.log(response.data);
                        if (response.data.code === 0) {
                            _this.data_group.list = response.data.data.results;
                            _this.data_group.pagination.total = response.data.data.totalCount;
                        } else {
                            _this.$message.error(response.data.msg);
                        }
                    }, {
                        requestBody: true,
                        before: function () {
                            _this.btn_disabled = true;
                        },
                        after: function () {
                            _this.btn_disabled = false;
                        }
                    });
            },
            openDialog: function (type) {
                var _this = this;
                if (type === 'new') {
                    _this.dialogFormVisible = true;
                    _this.dialogTitle = "新增";
                    _this.form = {

                        id:null, // 主键Id
                        userId:null, // 用户Id
                        serviceOrderId:null, // 服务单号
                        companyName:null, // 公司名称
                        companyPhone:null, // 公司电话（服务热线）
                        handleDate:null, // 受理时间
                        engineer:null, // 工程师
                        customerName:null, // 客户名称
                        linkman:null, // 客户联系人（报修人）
                        serviceType:null, // 服务类型（0：普通客户服务；1：VIP客户服务）
                        serviceMode:null, // 服务方式（0：上门服务；1：远程服务）
                        brandSpecs:null, // 品牌规格
                        serialNumber:null, // 序列号
                        count:null, // 数量
                        faultDescribe:null, // 故障描述（故障现象）
                        vistDate:null, // 上门时间
                        completDate:null, // 完成时间
                        repairResult:null, // 维修结果
                        serviceQuality:null, // 服务质量（0：非常满意；1：满意；2：一般；3：不满意）
                        customerAdvise:null, // 客户意见
                        customerSignImage:null, // 客户签字的图片地址
                        createrId:null, // 创建人Id
                        createrName:null, // 创建人名字
                        createDate:null, // 创建时间
                        updaterId:null, // 更新人Id
                        updaterName:null, // 更新人名字
                        updateDate:null, // 更新时间
                        isDeleted:null, // 是否删除（0未删除，1已删除）

                    }
                } else if (type === 'edit') {
                    if (_this.data_group.multipleSelection.length != 1) {
                        _this.$message.warning("请选择一条数据！");
                    }else {
                        _this.dialogFormVisible = true;
                        _this.dialogTitle = "编辑";
                        var id = _this.data_group.multipleSelection[0].id;
                        _this.getById(id);
                    }
                } else if (type === 'delete') {
                    if (_this.data_group.multipleSelection.length === 0) {
                        _this.$message.warning("请选择一条数据！");
                    }else {
                        var ids = '';
                        for(var i=0;i<_this.data_group.multipleSelection.length;i++){
                            if(i==0){
                                ids = _this.data_group.multipleSelection[i].id;
                            }else{
                                ids += ","+_this.data_group.multipleSelection[i].id;
                            }
                        }
                        _this.deleteById(ids);
                    }
                }
            },
            submitForm: function (formName) {
                var _this = this;
                _this.$refs[formName].validate(function (valid) {
                    if (valid) {
                        _this.$confirm('确定操作吗?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(function () {
                            if (_this.dialogTitle === "新增") {
                                _this.save();
                            } else if (_this.dialogTitle === "编辑") {
                                _this.update();
                            }
                        }).catch(function () {
                        });
                    }
                });
            },
            onSelectionChange: function (val) {
                this.data_group.multipleSelection = val;
            },
            getById: function (id) {
                var _this = this;
                //请求参数
                var req = {};
                $UU.http.get("/ls-com.fuck.service-form/get-by-id/" + id,
                    req
                    , function (response) {
                        //获取回调数据
                        console.log(response.data);
                        if (response.data.code === 0) {
                            _this.form = response.data.data;
                        } else {
                            _this.$message.error(response.data.msg);
                        }
                    }, {
                        requestBody: true,
                        before: function () {
                            _this.btn_disabled = true;
                        },
                        after: function () {
                            _this.btn_disabled = false;
                        }
                    });
            },
            deleteById: function (id) {
                var _this = this;
                _this.$confirm('确定操作吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(function () {
                    //请求参数
                    var req = {};
                    $UU.http.delete("/ls-com.fuck.service-form/delete-by-id/" + id,
                        req
                        , function (response) {
                            //获取回调数据
                            console.log(response.data);
                            if (response.data.code === 0) {
                                _this.query();
                            } else {
                                _this.$message.error(response.data.msg);
                            }
                        });
                }).catch(function () {
                });
            },
            setData: function () {
                var _this = this;
            },
            save: function () {
                var _this = this;
                console.info(_this.form);
                $UU.http.post("/ls-com.fuck.service-form/save",
                    _this.form
                    , function (response) {
                        //获取回调数据
                        console.log(response.data);
                        if (response.data.code === 0) {
                            _this.$message.success(response.data.msg);
                            _this.dialogFormVisible = false;
                            _this.query();
                        } else {
                            _this.$message.error(response.data.msg);
                        }
                    }, {
                        requestBody: true,
                        before: function () {
                            _this.btn_disabled = true;
                        },
                        after: function () {
                            _this.btn_disabled = false;
                        }
                    });
            },
            update: function () {
                var _this = this;
                _this.setData();
                $UU.http.put("/ls-com.fuck.service-form/update",
                    _this.form
                    , function (response) {
                        //获取回调数据
                        console.log(response.data);
                        if (response.data.code === 0) {
                            _this.$message.success(response.data.msg);
                            _this.dialogFormVisible = false;
                            _this.query();
                        } else {
                            _this.$message.error(response.data.msg);
                        }
                    }, {
                        requestBody: true,
                        before: function () {
                            _this.btn_disabled = true;
                        },
                        after: function () {
                            _this.btn_disabled = false;
                        }
                    });
            },
            handleCurrentChange: function (val) {
                if (null !== val) {
                    this.data_group.multipleSelection = val.id;
                }
            },
        }
    });



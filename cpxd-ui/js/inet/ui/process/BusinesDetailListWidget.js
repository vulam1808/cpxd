/**
 * Created by HS on 3/10/2016.
 */
// #PACKAGE: businessdetail-namebusiness-list
// #MODULE: BusinessDetailListWidget

$(function() {
    var resource = {
        common: ita.resources.common,
        validate: ita.resources.validate
    };

    var url = {
        view: iNet.getUrl('ita/businessdetail/load')
        /* save: iNet.getUrl('ita/areabusiness/save'),
         update: iNet.getUrl('ita/areabusiness/update'),
         del: iNet.getUrl('ita/areabusiness/delete')*/
    };
    iNet.ns("iNet.ui", "iNet.ui.ita");
    iNet.ui.ita.BusinessDetailListWidget = function (config) {
        var __config = config || {};
        iNet.apply(this, __config);// apply configuration
        this.id = this.id || 'businessdetail-namebusiness-list';

        iNet.ui.ita.BusinessDetailListWidget.superclass.constructor.call(this);

        var me= this;

        var dataSource = new iNet.ui.grid.DataSource({
            columns : [{
                type : 'selection',
                align: 'center',
                width : 30
            },{
                property : 'nameBusiness',
                label : resource.common.nameBusiness,
                sortable : true,
                type : 'text',
                validate : function(v) {
                    if (iNet.isEmpty(v))
                        return 'Name must not be empty';
                }
            }]
        });
        //load grid
        this.grid = new iNet.ui.grid.Grid({
            id : 'businessdetail-namebusiness-grid',
            dataSource : dataSource,
            url: url.view,
            firstLoad: true,
            idProperty : 'uuid',
            pageSize: 10,
            convertData: function (data) {
                var __data = data || {};
                var __items = __data.items || [];
                return __items;
            },
            editable: false
        });




    };

    iNet.extend(iNet.ui.ita.BusinessDetailListWidget, iNet.ui.app.widget);
    var wgabc = new iNet.ui.ita.BusinessDetailListWidget();
    wgabc.show();


});
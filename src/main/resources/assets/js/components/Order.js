class Order extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        let { order } = this.props;

        order.datePretty = moment(order.created).format('MMM DD, YYYY hh:mm:ss a');

        let order_items = [];

        if(order.items) {
            order_items = order.items.map(item => (
                <tr key={item.id}>
                    <td> {item.name} </td>
                    <td> {item.quantity} </td>
                    <td> {item.rate} </td>
                </tr>
            ));
        }

        return (
            <div className="bg-tertiary mb-3 p-3">
                <div className="row">
                    <div className="col">
                        <h5>
                            Order # {order.id}
                        </h5>
                    </div>
                    <div className="col text-end small">
                        {order.datePretty}
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <table className="table table-striped">
                            <thead>
                                <tr>
                                    <th> Item </th>
                                    <th> Quantity </th>
                                    <th> Rate </th>
                                </tr>
                            </thead>
                            <tbody>
                                {order_items}
                            </tbody>
                        </table>
                    </div>
                </div>
                <div className="row mt-2">
                    <div className="col">
                        Total ${order.total}
                    </div>
                </div>
            </div>
        )
    }

}

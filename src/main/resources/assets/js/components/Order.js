class Order extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        const { order } = this.props;
        let order_items = [];

        if(order.items) {
            order_items = order.items.map(item => (
                <div> {item.name} </div>
            ));
        }

        return (
            <div>
                <div className="row">
                    <div className="col">
                        Order # {order.id}
                    </div>
                    <div className="col text-end">
                        {order.datePretty}
                    </div>
                </div>
                {order_items}
                <div className="row">
                    <div className="col">
                        Total ${order.total}
                    </div>
                </div>
            </div>
        )
    }

}

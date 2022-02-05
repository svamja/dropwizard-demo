class Order extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        const { order } = this.props;
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
                <div className="row">
                    <div className="col">
                        Total ${order.total}
                    </div>
                </div>
            </div>
        )
    }

}

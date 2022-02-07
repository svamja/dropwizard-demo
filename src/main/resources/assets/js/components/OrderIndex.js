class OrderIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          orders: [],
        };
    }

    async componentDidMount() {
        let res = await fetch("/api/orders");
        let orders = await res.json();
        this.setState({ orders });
    }

    async paginate(event, page) {
        event && event.preventDefault();
        page = page || 0;
        let url = "/api/orders?page=" + page;
        let res = await fetch(url);
        let orders = await res.json();
        this.setState({ orders });
    }

    render() {

        const { orders, current_page, input_order } = this.state;
        const paginate = this.paginate.bind(this);
        let order_list = orders.map(order => <Order key={order.id} order={order} />);

        return (
            <div className="container">
                <div className="row justify-content-end">
                    <div className="col-auto">

                        <ul className="pagination">
                            <li className="page-item">
                                <a className="page-link" href="#" onClick={(event) => paginate(event, 0)}>1</a>
                            </li>
                            <li className="page-item">
                            <a className="page-link" href="#" onClick={(event) => paginate(event, 1)}>2</a>
                            </li>
                            <li className="page-item">
                            <a className="page-link" href="#" onClick={(event) => paginate(event, 2)}>3</a>
                            </li>
                        </ul>

                    </div>
                </div>
                {order_list}
            </div>
        );
    }
  }
  

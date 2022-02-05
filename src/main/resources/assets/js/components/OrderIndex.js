class OrderIndex extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          orders: []
        };
    }

    async componentDidMount() {
        let res = await fetch("/api/orders");
        let orders = await res.json();
        this.setState({ orders });
    }

    render() {
        const { orders } = this.state;
        let order_list = orders.map(order => <Order key={order.id} order={order} />);
      return (
        <div className="container">
            <Header />
          <div className="row">
            <h3 className="bg-light py-2">Orders</h3>
          </div>
          {order_list}
        </div>
      );
    }
  }
  

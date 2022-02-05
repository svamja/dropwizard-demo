class Header extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span className="fs-4">Order Admin (Demo)</span>
                </a>
            
                <ul className="nav nav-pills">
                    <li className="nav-item"><a href="#" className="nav-link active" aria-current="page">Orders</a></li>
                    <li className="nav-item"><a href="#" className="nav-link">Clients</a></li>
                    <li className="nav-item"><a href="#" className="nav-link">Billing</a></li>
                    <li className="nav-item"><a href="#" className="nav-link">Help</a></li>
                </ul>
            </header>
        );
    }

}

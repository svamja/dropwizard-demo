class Header extends React.Component {

    constructor(props) {
        super(props);
        this.state = { current_page: 'Orders' }
    }

    onClick(page) {
        this.setState({ current_page: page });
        this.props.onPageChange(page);
    }

    render() {
        const { current_page } = this.state;

        const pages = [ 'Orders', 'Create Order' ];

        let header_links = pages.map(page => (
            <HeaderLink key={page} isActive={current_page == page} title={page} onClick={() => this.onClick(page)} />
        ));

        return (
            <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span className="fs-4">Order Admin (Demo)</span>
                </a>
            
                <ul className="nav nav-pills">
                    {header_links}
                    <li className="nav-item">
                        <a href="https://github.com/svamja/dropwizard-demo" className="nav-link">Github</a>
                        </li>
                </ul>
            </header>
        );
    }

}

class HeaderLink extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        let className = 'nav-link';
        if(this.props.isActive) {
            className += ' active';
        }
        return (
            <li className="nav-item">
                <a href="#" className={className}
                    onClick={this.props.onClick}
                >
                    {this.props.title}
                </a>
            </li>
        )
    }

}

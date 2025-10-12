<nav>
    <a href="/">
        <img src="/srtoasty/cards/letter.png" alt="inbox" />
    </a>
    <a href="/">
        <img src="/srtoasty/cards/contact-book.png" alt="contact book" />
    </a>
    <a href="/">
        <img src="/srtoasty/cards/news.png" alt="news" />
    </a>

    <a href="/">
        <img src="/srtoasty/cards/notes.png" alt="notes" />
    </a>
</nav>

<style>
    nav {
        padding: 6px 10px 0px 10px;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding-bottom: 35px;
    }
    a {
        transition: all 0.5s;
        position: relative;
        bottom: -10px;
        margin-bottom: -15px;
    }
    a:active img {
        filter: brightness(1.1);
    }
    a:hover {
        bottom: 10px;
    }
    a:hover::after {
        position: absolute;
        left: -35px;
        bottom: -10px;
        transform: rotateY(180deg);
        content: url("icons/aspecs/Hand3.png");
    }
    img:nth-child(even) {
        left: 16px;
    }
    img {
        width: calc(48px * 3);
        display: block;
        object-fit: cover;
        object-position: top;
    }
</style>

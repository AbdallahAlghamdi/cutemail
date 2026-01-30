<div>
  <a href="/inbox">
    <img src="srtoasty/cards/letter.png" alt="contacts" />
  </a>
  <a href="/contacts">
    <img src="srtoasty/cards/contact-book.png" alt="contacts" />
  </a>
  <a href="/news">
    <img src="srtoasty/cards/news.png" alt="contacts" />
  </a>
  <a href="/notes">
    <img src="srtoasty/cards/notes.png" alt="contacts" />
  </a>
  <a href="/settings">
    <img src="srtoasty/cards/settings.png" alt="contacts" />
  </a>
</div>

<style>
  img {
    width: calc(48px * 2);
    height: calc(26px * 2);
    display: block;
    object-fit: cover;
    object-position: top;
  }
  a {
    position: relative;
    bottom: -10px;
    margin-bottom: -10px;
    transition: all 0.5s;
    /* background-color: blue; */
  }
  a:nth-child(even) {
    left: -5px;
  }
  a:last-child {
    margin-bottom: 20px;
  }
  a:active img {
    filter: brightness(1.1);
  }

  a:hover {
    bottom: 15px;
  }
  div {
    align-items: center;
    padding: 8px;
    display: flex;
    flex-direction: column;
    background-color: #fee1b8;
    border: 2px #a57855 solid;
    /* border-radius: 10px; */
    box-shadow:
      inset 0px 0px 0px 1px #e2b592,
      inset 0px 0px 5px 5px #a57855;
    width: 100%;
  }
</style>

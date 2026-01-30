<script>
  import Envelope from "../../components/Envelope.svelte";
</script>

<section class="toolbar">
  <button class="toolbar-button">
    <span>New</span>
  </button>
  <!-- <button class="toolbar-button">Delete</button> -->
</section>
<section class="mailbox">
  <img src="envelope.png" alt="" />
  <Envelope title="Test test, Hello?" sender="Gargemi" />
  <Envelope title="Test test, Hello?" sender="Gargemi" />
  <Envelope title="Test test, Hello?" sender="Gargemi" />
  <Envelope title="Test test, Hello?" sender="Gargemi" />
  <!-- <Envelope sender="Gargemi" /> -->
</section>

<style>
  img {
    width: 480px;
  }
  .toolbar {
    height: 50px;
  }
  .mailbox {
    padding: 2px;
    flex-grow: 1;
    /* background-color: red; */
    align-items: center;
    display: flex;
    flex-direction: column;
    overflow: scroll;
  }
  span {
    vertical-align: middle;
    text-align: center;
  }

  button {
    display: flex;
    gap: 10px;
    align-items: center;
    position: relative;
    background-color: transparent;
    font-size: 16px;
  }
  span {
    position: relative;
    top: -1px;
  }
</style>

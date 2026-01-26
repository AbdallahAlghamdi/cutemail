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
  <Envelope sender="Gargemi" />
  <Envelope sender="Gargemi" />
</section>

<style>
  .toolbar {
    height: 100px;
  }
  .mailbox {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    background-color: red;
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

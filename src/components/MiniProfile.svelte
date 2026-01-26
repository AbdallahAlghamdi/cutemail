<script>
  let { avatar, name } = $props();
</script>

<div title={name}>
  <img src={avatar} alt="user avatar" />
  <p>♥{name}</p>
</div>

<style>
  p {
    overflow: hidden;
    text-overflow: ellipsis;
  }
  div {
    cursor: pointer;
    font-size: 16px;
    text-align: center;
    display: flex;
    flex-direction: column;
    gap: 8px;
    border: 2px #a57855 solid;
    padding: 4px;
    width: calc(16px * 10 + 8);
    background-color: #fee1b8;
    width: 180px;
    overflow: hidden;
  }
  img {
    height: 150px;
    width: 100%;
    object-fit: cover;
  }
</style>

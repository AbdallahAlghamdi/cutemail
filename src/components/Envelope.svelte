<script lang="ts">
    let { sender, title } = $props();
</script>

<section class="envelope">
    <div class="sender">
        <address title={sender}>
            {sender}
        </address>
        <time>2015-01-01, 12:02PM</time>
    </div>
    <hr />
    <h3 {title}>
        {title}
    </h3>
</section>

<style>
    hr {
        border-style: solid;
        border-color: #c79f79;
    }
    h3 {
        height: 100%;

        text-align: center;
        font-size: 16px;
        overflow: hidden;
        text-overflow: ellipsis;
        font-weight: normal;
    }

    .sender {
        display: flex;
        flex-direction: column;
        gap: 4px;
    }
    address::before {
        content: "♠";
        padding-right: 4px;
    }
    address {
        overflow: hidden;
        text-overflow: ellipsis;
        font-style: normal;
        text-wrap: nowrap;
    }
    .envelope {
        box-sizing: border-box;
        cursor: pointer;
        box-shadow: 0px 0px 0px 2px #663931;
        margin-bottom: -100px;
        position: relative;
        top: 0px;
        display: flex;
        flex-direction: column;
        gap: 14px;
        padding: 14px;
        height: 228px;
        width: 480px;
        border-image: url("letter.png") 8 fill;
        border-image-width: 16px;
        border-image-repeat: repeat;
        transition: margin 0.6s;
    }
    .envelope:nth-child(even) {
        right: 10px;
    }
    .envelope:nth-child(odd) {
        left: 10px;
    }
    .envelope:hover {
        margin-bottom: 10px;
    }
    img {
        width: calc(16px * 3);
        height: calc(16px * 3);
    }
</style>
